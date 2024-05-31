package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExercisesTopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Exercises",
            color = Color.White,
            fontFamily = FontFamily.Default,
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(10.dp)
                .align(
                    Alignment.CenterVertically
                )
        )
    }
}