package com.example.gymforce.screens.type

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.models.TrainingTypeItem
import com.example.gymforce.screens.Exercises.TrainingCard

@Composable
fun TrainingTypeLazyColumn(navHostController: NavHostController) {
    val list =  listOf(
        TrainingTypeItem.TrainingOne,
        TrainingTypeItem.TrainingTwo,
        TrainingTypeItem.TrainingThree,
        TrainingTypeItem.TrainingFour,
        TrainingTypeItem.TrainingFive,
        TrainingTypeItem.TrainingSex,

    )
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp)
    ) {
        item {
            list.forEach { item ->
                TrainingTypeCard(
                    name = item.nameOfTraining,
                    image = item.image,
                    navHostController
                )

            }
        }
    }

}