package com.example.gymforce.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.domain.repo.AuthRepository
import com.example.gymforce.ui.navigation.BottomNavItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authRepository: AuthRepository // Inject the repository to check login status

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            // Check if the user is already logged in
            val startDestination = if (authRepository.getCurrentUser() != null) {
                BottomNavItem.Home.screenRoute // If user is logged in, navigate to Home
            } else {
                "Login" // Otherwise, navigate to Login
            }

            MainScreenView(navController, startDestination)
        }
    }
}

