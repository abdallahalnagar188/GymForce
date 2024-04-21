package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gymforce.models.TrainingCardItem
@Composable
fun ExercisesLazyColumn(navHostController: NavHostController) {
    val list = listOf(
        TrainingCardItem.ChestDay,
        TrainingCardItem.BackDay,
        TrainingCardItem.ShoulderDay,
        TrainingCardItem.ArmsDay,
        TrainingCardItem.LegDay,
        TrainingCardItem.Off,
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
                    image = item.workOutImage,
                    navHostController
                )

            }
        }
    }
}