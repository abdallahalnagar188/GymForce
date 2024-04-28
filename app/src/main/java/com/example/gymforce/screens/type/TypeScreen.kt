package com.example.gymforce.screens.type

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun TypeScreen(
    name: String,
    navHostController: NavHostController
) {
    TypeScreenContent(name, navHostController = navHostController)
}