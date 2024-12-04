package com.example.gymforce.ui.screens.healthyForm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.ui.screens.profile.ProfileViewModel

@Composable
fun HealthFormScreen(
    navHostController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val userType by viewModel.userType.collectAsState()
    if (userType == "Trainer") {
        TrainerHealthFormContent(navHostController)
    } else {
        UserHealthFormContent(navHostController)
    }
}

