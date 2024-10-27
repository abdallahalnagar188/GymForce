package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymforce.common.fontMedium

@Composable
fun ExercisesByBodyPartContent(navHostController: NavHostController, bodyPartName: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppBar(
            navHostController = navHostController,
            partBodyName = bodyPartName
        )
        Text(
            text = bodyPartName,
            fontSize = 30.sp,
            color = Color.White,
            fontFamily = fontMedium,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )

    }

}