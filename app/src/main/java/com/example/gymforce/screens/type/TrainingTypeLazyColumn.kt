package com.example.gymforce.screens.type

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gymforce.viewModel.ExercisesViewModel

@Composable
fun TrainingTypeLazyColumn(navHostController: NavHostController) {
    val vm: ExercisesViewModel = viewModel()
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp)
    ) {
        item {
            vm.getExercises().forEach { item ->
                TrainingTypeCard(
                    name = item.nameOfTraining,
                    image = item.image,
                    navHostController
                )
            }
        }
    }
}