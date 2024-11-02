package com.example.gymforce.ui.screens.auth.regester

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.repo.AuthRepository
import com.example.gymforce.common.UiState
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<UiState<FirebaseUser?>>(UiState.Empty)
    val authState: StateFlow<UiState<FirebaseUser?>> = _authState

    fun register(name: String, email: String, password: String, weight: Double, height: Double, imageUri: Uri?) {
        viewModelScope.launch {
            _authState.value = UiState.Loading

            val result = authRepository.signUpWithEmailAndPassword(email, password, name, weight, height, imageUri?.toString())

            if (result.isSuccess) {
                val user = result.getOrNull()
                user?.let {
                    // Upload image and get URL
                    val imageUrl = imageUri?.let { uri ->
                        uploadImageToFirebaseStorage(uri, it.uid) // Your method to upload image
                    }

                    val userData = User(
                        uid = it.uid,
                        name = name,
                        email = email,
                        weight = weight,
                        height = height,
                        photoUrl = imageUrl // Include the image URL in User object
                    )

                    val firestoreResult = authRepository.addUserToFirestore(userData)
                    if (firestoreResult.isSuccess) {
                        _authState.value = UiState.Success(user)
                    } else {
                        _authState.value = UiState.Error(firestoreResult.exceptionOrNull()?.message ?: "Failed to save user data")
                    }
                }
            } else {
                _authState.value = UiState.Error(result.exceptionOrNull()?.message ?: "Unknown error during registration")
            }
        }
    }



    // Function to upload image to Firebase Storage
    private suspend fun uploadImageToFirebaseStorage(imageUri: Uri, uid: String): String? {
        val storageRef = FirebaseStorage.getInstance().reference.child("users/$uid/profile.jpg")
        return try {
            storageRef.putFile(imageUri).await()
            storageRef.downloadUrl.await().toString() // Get the download URL
        } catch (e: Exception) {
            null
        }
    }

}

