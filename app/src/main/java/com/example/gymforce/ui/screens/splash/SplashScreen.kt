package com.example.gymforce.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.gymforce.ui.navigation.BottomNavItem
import com.example.gymforce.ui.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen( onNavigate: (String) -> Unit) {
    // Use a coroutine scope to delay the splash screen before navigation
    LaunchedEffect(Unit) {
        delay(2000) // Display splash screen for 2 seconds (adjust as needed)

        // Determine next destination based on user status
        val nextDestination = when {
           // !isOnboardingCompleted(context) -> Screen.Onboarding.route
            BottomNavItem.Home.screenRoute == BottomNavItem.Home.screenRoute -> BottomNavItem.Home.screenRoute
            else -> Screen.Login.route
        }

        onNavigate(nextDestination) // Trigger navigation after the delay
    }

    SplashContent()
}

