package com.example.gymforce.ui.screens.profile

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.navigation.Screen

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val user = viewModel.getCurrentUser()
    val userName by viewModel.userName.collectAsState()
    val email by viewModel.userEmail.collectAsState()
    val weight by viewModel.userWeight.collectAsState()
    val height by viewModel.userHeight.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val userImageUrl by viewModel.userImageUrl.collectAsState() // Collect user image URL

    // Display loading indicator while fetching data
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressAnimated(modifier = Modifier.size(50.dp))
        }
    } else {
        ProfileScreenContent(
            userName = userName ?: "",
            userHeight = height?.toString() ?: "0",
            userWeight = weight?.toString() ?: "0",
            userImageUrl = userImageUrl?:"no image",
            onSignOut = {
                viewModel.signOut() // Call the sign-out function
                navController.navigate(Screen.Login.route){
                    popUpTo(Screen.Profile.route){
                        inclusive = true
                    }
                }

                // Optionally, navigate to login screen here after sign-out
            }
        )
    }
}
