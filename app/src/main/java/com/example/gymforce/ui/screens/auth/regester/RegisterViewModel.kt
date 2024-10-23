package com.example.gymforce.ui.screens.auth.regester

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repo.AuthRepository
import com.example.gymforce.common.UiState
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<UiState<FirebaseUser?>>(UiState.Empty)
    val authState: StateFlow<UiState<FirebaseUser?>> = _authState

    fun register(name: String, email: String, password: String, weight: Double, height: Double) {
        viewModelScope.launch {
            _authState.value = UiState.Loading
            val result = authRepository.signUpWithEmailAndPassword(email, password, name, weight, height)
            _authState.value = if (result.isSuccess) {
                UiState.Success(result.getOrNull())
            } else {
                UiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }
}
