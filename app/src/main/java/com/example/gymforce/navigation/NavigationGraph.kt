package com.example.gymforce.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gymforce.screens.Exercises.ExercisesScreen
import com.example.gymforce.screens.setting.SettingScreen
import com.example.gymforce.screens.tools.ToolsScreen
import com.example.gymforce.screens.type.TypeScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Exercises.screen_route
    ) {
        composable(BottomNavItem.Setting.screen_route) {
            SettingScreen()
        }
        composable(BottomNavItem.Exercises.screen_route) {
            ExercisesScreen(navController)
        }
        composable(BottomNavItem.Tools.screen_route) {
            ToolsScreen()
        }
        composable("type training screen"){
            TypeScreen(navController)
        }

    }

}