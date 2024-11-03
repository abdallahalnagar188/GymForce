package com.example.gymforce.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.domain.repo.AuthRepository
import com.example.gymforce.ui.navigation.Screen
import com.example.gymforce.utils.OnboardingPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            // Determine the starting destination based on onboarding and login status
            val startDestination = when {
                !isOnboardingCompleted() -> Screen.Onboarding.route // Start with Onboarding if not completed
                authRepository.getCurrentUser() != null -> Screen.Home.route // Start with Home if user is logged in
                else -> Screen.Login.route // Otherwise, start with Login
            }

            MainScreenView(navController = navController, startDestination = startDestination)
        }
    }

    private fun isOnboardingCompleted(): Boolean {
        val preferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        return preferences.getBoolean("onboarding_completed", false)
    }
}





