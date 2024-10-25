package com.example.gymforce.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gymforce.R
import com.example.gymforce.ui.screens.auth.login.LoginScreen
import com.example.gymforce.ui.screens.auth.regester.RegisterScreen
import com.example.gymforce.ui.screens.home.HomeScreen
import com.example.gymforce.ui.screens.home.exercises.ExercisesByBodyPartScreen
import com.example.gymforce.ui.screens.profile.ProfileScreen
import com.example.gymforce.ui.screens.setting.SettingScreen
import com.example.gymforce.ui.screens.tools.ToolsScreen

@Composable
fun NavigationGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.background(color = colorResource(id = R.color.black))
    ) {
        // Bottom navigation screens
        composable(BottomNavItem.Setting.screenRoute) {
            SettingScreen()
        }
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Tools.screenRoute) {
            ToolsScreen(navController)
        }
        composable(BottomNavItem.Profile.screenRoute) {
            ProfileScreen(navController)
        }

        // Exercises screen with body part argument
        composable(
            route = "ExercisesByBodyPartScreen/{bodyPartName}",
            arguments = listOf(navArgument("bodyPartName") { type = NavType.StringType })
        ) { backStackEntry ->
            val bodyPartName = backStackEntry.arguments?.getString("bodyPartName") ?: ""
            ExercisesByBodyPartScreen(bodyPartName, navController)

        }

        // Login screen
        composable("Login") {
            LoginScreen(navController)
        }

        // Register screen
        composable("Register") {
            RegisterScreen(navController)
        }
    }
}
