package com.example.gymforce.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymforce.R
import com.example.gymforce.ui.navigation.MyBottomNavigation
import com.example.gymforce.ui.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != "Login" && currentRoute != "Register") {
                MyBottomNavigation(navController = navController)
            }
        },
        modifier = Modifier.background(color = colorResource(id = R.color.black_low))
    ) {
        NavigationGraph(navController = navController)
    }
}
