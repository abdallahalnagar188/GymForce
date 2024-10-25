package com.example.gymforce.ui.screens.home.exercises

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.ui.screens.home.HomeViewModel

@Composable
fun ExercisesByBodyPartScreen(bodyPartName: String, navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val exercises = viewModel.getExercises(bodyPartName)
    Log.e("ExercisesByBodyPartScreen", "Exercises: $bodyPartName")

    ExercisesByBodyPartContent(navHostController,bodyPartName)
}