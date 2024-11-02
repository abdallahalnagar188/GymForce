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
import com.example.gymforce.ui.screens.home.exercise_details.ExerciseDetailsScreen
import com.example.gymforce.ui.screens.home.exercises.ExercisesByBodyPartScreen
import com.example.gymforce.ui.screens.onboarding.OnboardingScreen
import com.example.gymforce.ui.screens.profile.ProfileScreen
import com.example.gymforce.ui.screens.setting.SettingScreen
import com.example.gymforce.ui.screens.tools.ToolsScreen

@Composable
fun NavigationGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.background(color = colorResource(id = R.color.baby_blue))
    ) {
//        // Splash screen
//        composable(Screen.Splash.route) {
//            SplashScreen { nextDestination ->
//                navController.navigate(nextDestination) {
//                    popUpTo(Screen.Splash.route) { inclusive = true }
//                }
//            }
//        }

        // Onboarding screen
        composable(Screen.Onboarding.route) {
            OnboardingScreen {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Onboarding.route) { inclusive = true }
                }
            }
        }

        // Bottom navigation screens
        composable(BottomNavItem.Setting.screenRoute) { SettingScreen() }
        composable(BottomNavItem.Home.screenRoute) { HomeScreen(navController) }
        composable(BottomNavItem.Tools.screenRoute) { ToolsScreen(navController) }
        composable(BottomNavItem.Profile.screenRoute) { ProfileScreen(navController) }

        // Exercises screens
        composable(
            route = Screen.ExercisesByBodyPartScreen.route,
            arguments = listOf(navArgument(Screen.ExercisesByBodyPartScreen.argument ?: "") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val bodyPartName = backStackEntry.arguments?.getString(Screen.ExercisesByBodyPartScreen.argument) ?: ""
            ExercisesByBodyPartScreen(bodyPartName, navController)
        }

        composable(
            route = Screen.ExerciseDetailsScreen.route,
            arguments = listOf(navArgument(Screen.ExerciseDetailsScreen.argument ?: "") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val exerciseId = backStackEntry.arguments?.getString(Screen.ExerciseDetailsScreen.argument) ?: ""
            ExerciseDetailsScreen(exerciseId, navController)
        }

        // Authentication screens
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
    }
}


