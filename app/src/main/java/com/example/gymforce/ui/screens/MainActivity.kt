package com.example.gymforce.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.domain.repo.AuthRepository
import com.example.gymforce.common.LocalUtil
import com.example.gymforce.ui.navigation.Screen
import com.example.gymforce.common.OnboardingPreferences.isOnboardingCompleted
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize LocalUtil and set the locale
        LocalUtil.init(applicationContext)
        LocalUtil.loadLocal(this)

        setContent {
            val navController = rememberNavController()

            val startDestination = when {
                !isOnboardingCompleted(this) -> Screen.Onboarding.route
                authRepository.getCurrentUser() != null -> Screen.Home.route
                else -> Screen.Login.route
            }

            MainScreenView(navController = navController, startDestination = startDestination)
        }
    }
}





