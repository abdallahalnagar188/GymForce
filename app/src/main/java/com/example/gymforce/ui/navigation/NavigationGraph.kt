package com.example.gymforce.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gymforce.R
import com.example.gymforce.ui.screens.exercises.ExercisesScreen
import com.example.gymforce.ui.screens.setting.SettingScreen
import com.example.gymforce.ui.screens.tools.ToolsScreen
import com.example.gymforce.ui.screens.exercises.training_details.TrainingDetailsScreen
import com.example.gymforce.ui.screens.exercises.type.TypeScreen
import com.example.gymforce.ui.screens.profile.ProfileScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.screen_route,
        modifier = Modifier.background(color = colorResource(id = R.color.black))
    ) {
        composable(BottomNavItem.Setting.screen_route) {
            SettingScreen()
        }
        composable(BottomNavItem.Home.screen_route) {
            ExercisesScreen(navController)
        }
        composable(BottomNavItem.Tools.screen_route) {
            ToolsScreen(navController)
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen(navController)
        }


        composable(
            route = "TrainingDetails/{trainingDetailsName}",
            arguments = listOf(
                navArgument("trainingDetailsName",)
                {
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