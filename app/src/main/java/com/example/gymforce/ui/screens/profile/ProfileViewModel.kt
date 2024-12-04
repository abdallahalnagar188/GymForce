package com.example.gymforce.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.repo.AuthRepository
import com.example.gymforce.di.GymForceApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _userName = MutableStateFlow<String?>(null)
    val userName: StateFlow<String?> = _userName

    private val _userEmail = MutableStateFlow<String?>(null)
    val userEmail: StateFlow<String?> = _userEmail

    private val _userAge = MutableStateFlow<Int?>(null)
    val userAge: StateFlow<Int?> = _userAge

    private val _userGender = MutableStateFlow<String?>(null)
    val userGender: StateFlow<String?> = _userGender

    private val _userType = MutableStateFlow<String?>(null)
    val userType: StateFlow<String?> = _userType

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchUserProfile()
    }

    private fun fetchUserProfile() {
        val currentUser = authRepository.getCurrentUser()
        if (currentUser != null) {
            viewModelScope.launch {
                val userId = currentUser.uid
                authRepository.getUserFromFirestore(userId).fold(
                    onSuccess = { user ->
                        _userName.value = user.name
                        _userEmail.value = user.email
                        _userAge.value = user.age
                        _userGender.value = user.gender
                        _userType.value = user.userType
                        _isLoading.value = false
                    },
                    onFailure = {
                        _isLoading.value = false // Handle error appropriately
                    }
                )
            }
        } else {
            _isLoading.value = false // No user is signed in
        }
    }

    fun signOut() {
        viewModelScope.launch {
            authRepository.signOut()
        }
    }

    fun getCurrentUser() = authRepository.getCurrentUser()
}
