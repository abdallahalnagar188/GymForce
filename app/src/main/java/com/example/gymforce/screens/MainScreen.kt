package com.example.gymforce.screens

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.gymforce.navigation.MyBottomNavigation
import com.example.gymforce.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MyBottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }
}