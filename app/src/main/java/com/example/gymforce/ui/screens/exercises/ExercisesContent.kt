package com.example.gymforce.ui.screens.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ExercisesContent(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally
    )
    {
        Text(text = "Exercises Screen",fontSize = 30.sp, color = Color.White)


    }
}