package com.example.gymforce.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.ui.navigation.MyBottomNavigation
import com.example.gymforce.ui.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomNavigation(navController = navController) },
        modifier = Modifier.background(color = colorResource(id = R.color.black_low))
    ) {
        NavigationGraph(navController = navController)
    }
}