package com.example.gymforce.screens.training_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TrainingDetailsContent(trainingDetailsName: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally
    )
    {
        TrainingDetailsTopBar(trainingDetailsName = trainingDetailsName)

    }
}