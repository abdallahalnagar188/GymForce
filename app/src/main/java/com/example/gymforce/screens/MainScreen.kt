package com.example.gymforce.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.gymforce.navigation.MyBottomNavigation
import com.example.gymforce.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomNavigation(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}