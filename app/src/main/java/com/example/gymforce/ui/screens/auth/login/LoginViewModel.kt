package com.example.gymforce.ui.screens.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repo.AuthRepository
import com.example.gymforce.common.UiState
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    // Login state: success, loading, error
    private val _authState = mutableStateOf<UiState<FirebaseUser?>>(UiState.Empty)
    val authState: State<UiState<FirebaseUser?>> = _authState

    // Sign in method
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = UiState.Loading

            val result = authRepository.signInWithEmailAndPassword(email, password)

            _authState.value = if (result.isSuccess) {
                UiState.Success(result.getOrNull())
            } else {
                UiState.Error("Login failed: ${result.exceptionOrNull()?.message}")
            }
        }
    }

}
