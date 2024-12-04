package com.example.gymforce.ui.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.domain.models.User
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.commonUi.ShowToast
import com.example.gymforce.ui.navigation.Screen

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val userName by viewModel.userName.collectAsState()
    val email by viewModel.userEmail.collectAsState()
    val age by viewModel.userAge.collectAsState()
    val gender by viewModel.userGender.collectAsState()
    val userType by viewModel.userType.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val showToast = remember { mutableStateOf(false) }

    val user =
        if (userName != null && email != null && age != null && gender != null && userType != null) {
            User(
                uid = viewModel.getCurrentUser()?.uid ?: "",
                name = userName ?: "",
                email = email ?: "",
                age = age ?: 0,
                gender = gender ?: "N/A",
                userType = userType ?: "N/A"
            )
        } else null

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressAnimated(modifier = Modifier.size(50.dp))
        }
    } else {
        ProfileScreenContent(
            user = user ?: User(),
            onSignOut = {
                viewModel.signOut()

                showToast.value = true
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Profile.route) { inclusive = true }
                }
            },
            navHostController = navController
        )
    }

    if (showToast.value) {
        ShowToast(message = "Signed out successfully")
        showToast.value = false
    }
}

