package com.example.gymforce.screens.training_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gymforce.R

@Composable
fun TrainingDetailsContent(trainingDetailsName: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally
    )
    {
        TrainingDetailsTopBar(trainingDetailsName = trainingDetailsName)
        TrainingDetailsCard(
            image = R.drawable.chest,
            set = "3 Set X 3 Rap",
            description = "incline chest in the best train i now now and its very good"
        )

    }
}