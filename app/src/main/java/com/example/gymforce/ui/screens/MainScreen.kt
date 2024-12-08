package com.example.gymforce.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymforce.ui.navigation.MyBottomNavigation
import com.example.gymforce.ui.navigation.NavigationGraph
import com.example.gymforce.ui.navigation.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(navController: NavHostController, startDestination: String) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Define a list of routes where the bottom bar should be hidden
    val hideBottomBarRoutes = listOf(
        "Login",
        "Register",
        "ExercisesByBodyPartScreen/{bodyPartName}",
        "ExerciseDetailsScreen/{exerciseId}",
        "Onboarding",
        Screen.HealthForm.route,
        Screen.Trainers.route,
        Screen.FoodByCategory.route
    )

    val shouldShowBottomBar = currentRoute !in hideBottomBarRoutes

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                MyBottomNavigation(navController)
            }
        }
    ) {
        NavigationGraph(navController = navController, startDestination = startDestination)
    }
}


