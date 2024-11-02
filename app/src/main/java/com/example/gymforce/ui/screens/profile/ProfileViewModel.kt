package com.example.gymforce.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repo.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _userName = MutableStateFlow<String?>(null)
    val userName: StateFlow<String?> = _userName

    private val _userEmail = MutableStateFlow<String?>(null)
    val userEmail: StateFlow<String?> = _userEmail

    private val _userWeight = MutableStateFlow<Double?>(null)
    val userWeight: StateFlow<Double?> = _userWeight

    private val _userHeight = MutableStateFlow<Double?>(null)
    val userHeight: StateFlow<Double?> = _userHeight

    private val _userImageUrl = MutableStateFlow<String?>(null)
    val userImageUrl: StateFlow<String?> = _userImageUrl

    private val _isLoading = MutableStateFlow<Boolean>(true) // Add loading state
    val isLoading: StateFlow<Boolean> = _isLoading

    private val firestore = FirebaseFirestore.getInstance()
    private val currentUser = FirebaseAuth.getInstance().currentUser

    init {
        fetchUserProfile()
    }

    private fun fetchUserProfile() {
        val userId = currentUser?.uid
        if (userId != null) {
            firestore.collection("users").document(userId).get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        _userName.value = document.getString("name")
                        _userEmail.value = document.getString("email")
                        _userWeight.value = document.getDouble("weight")
                        _userHeight.value = document.getDouble("height")
                        _userImageUrl.value = document.getString("photoUrl")
                    }
                }
                .addOnFailureListener {
                    // Handle any errors here if needed
                }
                .addOnCompleteListener {
                    _isLoading.value = false // Set loading to false when complete
                }
        } else {
            _isLoading.value = false // Set loading to false if user ID is null
        }
    }
    fun signOut() {
        viewModelScope.launch {
            authRepository.signOut()
            // Optionally, handle post-sign-out actions (like navigating to the login screen)
        }
    }
    fun getCurrentUser() = authRepository.getCurrentUser()
}
