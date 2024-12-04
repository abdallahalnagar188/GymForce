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
import com.example.gymforce.ui.screens.healthyForm.HealthFormScreen
import com.example.gymforce.ui.screens.home.HomeScreen
import com.example.gymforce.ui.screens.home.exercise_details.ExerciseDetailsScreen
import com.example.gymforce.ui.screens.home.exercises.ExercisesByBodyPartScreen
import com.example.gymforce.ui.screens.onboarding.OnboardingScreen
import com.example.gymforce.ui.screens.profile.ProfileScreen
import com.example.gymforce.ui.screens.setting.SettingScreen
import com.example.gymforce.ui.screens.tools.ToolsScreen
import com.example.gymforce.ui.screens.trainersScreen.TrainersScreen

@Composable
fun NavigationGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.background(color = colorResource(id = R.color.baby_blue))
    ) {

        // Onboarding screen
        composable(Screen.Onboarding.route) {
            OnboardingScreen(onOnboardingComplete = {
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Onboarding.route) { inclusive = true }
                }
            })
        }

        // Authentication screens
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }

        // Home and bottom navigation screens
        composable(BottomNavItem.Setting.screenRoute) { SettingScreen() }
        composable(BottomNavItem.Home.screenRoute) { HomeScreen(navController) }
        composable(BottomNavItem.Tools.screenRoute) { ToolsScreen(navController) }
        composable(BottomNavItem.Profile.screenRoute) { ProfileScreen(navController) }
        composable(Screen.HealthForm.route) { HealthFormScreen(navController) }

        composable(Screen.Trainers.route) { backStackEntry ->
            val gender = backStackEntry.arguments?.getString("gender") ?: "Male" // Default to Male if no gender is provided
            TrainersScreen(navController, gender = gender)  // Pass gender to TrainersScreen
        }


        // Exercises screens
        composable(
            route = Screen.ExercisesByBodyPartScreen.route,
            arguments = listOf(navArgument(Screen.ExercisesByBodyPartScreen.argument ?: "") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val bodyPartName =
                backStackEntry.arguments?.getString(Screen.ExercisesByBodyPartScreen.argument) ?: ""
            ExercisesByBodyPartScreen(bodyPartName, navController)
        }

        composable(
            route = Screen.ExerciseDetailsScreen.route,
            arguments = listOf(navArgument(Screen.ExerciseDetailsScreen.argument ?: "") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val exerciseId =
                backStackEntry.arguments?.getString(Screen.ExerciseDetailsScreen.argument) ?: ""
            ExerciseDetailsScreen(exerciseId, navController)
        }
    }
}



