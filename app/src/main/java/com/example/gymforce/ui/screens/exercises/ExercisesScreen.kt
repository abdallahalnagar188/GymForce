package com.example.gymforce.ui.screens.exercises

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.viewModel.ExercisesViewModel

@Composable
fun ExercisesScreen(navHostController: NavHostController) {

    val viewModel = hiltViewModel<ExercisesViewModel>()
    ExercisesContent(navHostController)
    fetchExercises()

}

private fun fetchExercises() {
    // Implement the logic to fetch exercises from the server or local storage

}