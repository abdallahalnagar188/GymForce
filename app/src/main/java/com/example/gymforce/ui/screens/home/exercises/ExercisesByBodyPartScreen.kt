package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun ExercisesByBodyPartScreen(
    bodyPartName: String,
    navHostController: NavHostController,
    viewModel: ExercisesViewModel = hiltViewModel()
) {
    LaunchedEffect(bodyPartName) {
        viewModel.fetchExercises(bodyPartName)
    }

    val exercises = viewModel.exercisesFlow.collectAsLazyPagingItems()

    ExercisesByBodyPartContent(navHostController, bodyPartName, exercises,)
}


