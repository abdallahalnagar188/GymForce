package com.example.gymforce.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.gymforce.common.UserCacheManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSharedViewModel @Inject constructor(
    private val userCacheManager: UserCacheManager
) : ViewModel() {

    private val _user = mutableStateOf<User?>(null)
    val user: State<User?> = _user

    init {
        viewModelScope.launch {
            userCacheManager.cachedUser.collect { cachedUser ->
                _user.value = cachedUser
            }
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userCacheManager.saveUser(user)
            _user.value = user
        }
    }

    fun clearUser() {
        viewModelScope.launch {
            userCacheManager.clearUser()
            _user.value = null
        }
    }
}
