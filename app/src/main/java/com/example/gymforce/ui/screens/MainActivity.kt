package com.example.gymforce.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.domain.repo.AuthRepository
import com.example.gymforce.ui.navigation.BottomNavItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import android.content.Context
import android.content.SharedPreferences

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authRepository: AuthRepository // Inject the repository to check login status

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Perform onboarding and login checks here
        val startDestination = when {
            !isOnboardingCompleted(this) -> "Onboarding" // Show onboarding if not completed
            authRepository.getCurrentUser() != null -> BottomNavItem.Home.screenRoute // User is logged in
            else -> "Login" // User is not logged in
        }

        setContent {
            val navController = rememberNavController()
            MainScreenView(navController = navController, startDestination = startDestination)
        }
    }
}


fun isOnboardingCompleted(context: Context): Boolean {
    val preferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    return preferences.getBoolean("onboarding_completed", false)
}

fun setOnboardingCompleted(context: Context) {
    val preferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    preferences.edit().putBoolean("onboarding_completed", true).apply()
}



