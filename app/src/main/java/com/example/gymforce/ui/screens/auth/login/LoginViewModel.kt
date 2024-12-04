package com.example.gymforce.ui.screens.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.repo.AuthRepository
import com.example.gymforce.common.UiState
import com.example.gymforce.common.UserCacheManager
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userCacheManager: UserCacheManager // Injected cache manager
) : ViewModel() {

    private val _authState = mutableStateOf<UiState<User?>>(UiState.Empty)
    val authState: State<UiState<User?>> = _authState

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = UiState.Loading

            val result = authRepository.signInWithEmailAndPassword(email, password)

            if (result.isSuccess) {
                val firebaseUser = result.getOrNull()
                firebaseUser?.let {
                    // Map FirebaseUser to your User data model
                    val user = User(
                        uid = it.uid,
                        email = it.email ?: "",
                        name = it.displayName ?: "",
                        gender = "",
                        age = 0,
                        userType = "default"
                    )

                    // Cache the user
                    userCacheManager.saveUser(user)

                    _authState.value = UiState.Success(user)
                }
            } else {
                _authState.value = UiState.Error("Login failed: ${result.exceptionOrNull()?.message}")
            }
        }
    }

    fun clearUserData() {
        viewModelScope.launch {
            userCacheManager.clearUser()
        }
    }
}

