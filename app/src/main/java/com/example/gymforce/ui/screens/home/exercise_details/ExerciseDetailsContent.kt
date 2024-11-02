package com.example.gymforce.ui.screens.home.exercise_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.navigation.NavHostController
import com.example.gymforce.common.fontBold

@Composable
fun ExerciseDetailsContent(
    exerciseId: String,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AppBar(
            navHostController = navHostController,
            exerciseId = exerciseId
        )
        Text(
            text = exerciseId,
            color = Color.White,
            fontFamily = fontBold,
            fontSize = TextUnit.Unspecified
        )
    }

}