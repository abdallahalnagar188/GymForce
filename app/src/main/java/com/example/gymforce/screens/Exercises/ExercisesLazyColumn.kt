package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymforce.models.TrainingCardItem
@Composable
fun ExercisesLazyColumn() {
    val list = listOf(
        TrainingCardItem.ChestDay,
        TrainingCardItem.backDay,
        TrainingCardItem.sholderDay,
        TrainingCardItem.armsDay,
        TrainingCardItem.legDay,
        TrainingCardItem.off,
    )
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp)
    ) {
        item {
            list.forEach { item ->
                TrainingCard(
                    name = item.workOutName,
                    day = item.numOfDay,
                    image = item.workOutImage
                )

            }
        }


    }
}