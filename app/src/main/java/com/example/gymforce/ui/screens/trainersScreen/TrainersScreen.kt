package com.example.gymforce.ui.screens.trainersScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun TrainersScreen(navHostController: NavHostController,gender: String) {
    TrainersScreenContent(navHostController,gender)
}

