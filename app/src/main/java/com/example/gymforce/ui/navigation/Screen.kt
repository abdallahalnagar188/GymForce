package com.example.gymforce.ui.navigation

sealed class Screen(val route: String, val argument: String? = null) {
    data object Home : Screen("home")
    data object Setting : Screen("setting")
    data object Tools : Screen("tools")
    data object Profile : Screen("profile")
    data object Login : Screen("Login")
    data object Register : Screen("Register")
    data object ExercisesByBodyPartScreen : Screen("ExercisesByBodyPartScreen/{bodyPartName}", argument = "bodyPartName")
    data object ExerciseDetailsScreen : Screen("ExerciseDetailsScreen/{exerciseId}", argument = "exerciseId")
    data object Onboarding : Screen("Onboarding")
    data object Splash : Screen("Splash")
}