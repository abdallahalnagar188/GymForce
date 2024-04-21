package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ExercisesContent(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), Arrangement.Top,Alignment.CenterHorizontally) {
        ExercisesTopBar()
        ExercisesLazyColumn(navHostController)

    }

}