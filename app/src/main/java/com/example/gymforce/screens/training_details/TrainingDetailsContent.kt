package com.example.gymforce.screens.training_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.gymforce.R

@Composable
fun TrainingDetailsContent(trainingDetailsName: String) {
    Column(
        modifier = Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.bg_2),
            contentScale = ContentScale.FillBounds),
        Arrangement.Top,
        Alignment.CenterHorizontally
    )
    {
        TrainingDetailsTopBar(trainingDetailsName = trainingDetailsName)
        TrainingDetailsCard(
            image = R.drawable.arms,
            set = "3 Set X 12 ",
            description = "incline chest in the best train i now now and its very good"
        )

    }
}