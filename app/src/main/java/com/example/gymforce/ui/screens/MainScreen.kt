package com.example.gymforce.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymforce.ui.navigation.MyBottomNavigation
import com.example.gymforce.ui.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(navController: NavHostController, startDestination: String) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Determine which routes should hide the bottom navigation
    val shouldShowBottomBar =
        currentRoute != "Login" && currentRoute != "Register" && currentRoute != "ExercisesByBodyPartScreen/{bodyPartName}"

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
