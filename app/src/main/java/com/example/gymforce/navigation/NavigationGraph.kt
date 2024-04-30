package com.example.gymforce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gymforce.screens.Exercises.ExercisesScreen
import com.example.gymforce.screens.setting.SettingScreen
import com.example.gymforce.screens.tools.ToolsScreen
import com.example.gymforce.screens.training_details.TrainingDetailsScreen
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
            ToolsScreen(navController)
        }


        composable(
            route = "TrainingDetails/{trainingDetailsName}",
            arguments = listOf(
                navArgument("trainingDetailsName") {
                    type = NavType.StringType
                }
            )

        ) {
            val trainingDetailsName = remember {
                it.arguments?.getString("trainingDetailsName")
            }
            TrainingDetailsScreen(trainingDetailsName?:"")

        }


        composable(
             route = "TypeTrainingScreen/{trainingName}",
             arguments = listOf(
                 navArgument("trainingName") {
                     type = NavType.StringType
                 }
             )
        ){
            val trainingName = remember {
                it.arguments?.getString("trainingName")
            }
            TypeScreen(trainingName!!, navController)
        }

    }

}