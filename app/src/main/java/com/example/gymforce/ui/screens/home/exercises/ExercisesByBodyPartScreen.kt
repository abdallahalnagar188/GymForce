package com.example.gymforce.ui.screens.home.exercises

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun ExercisesByBodyPartScreen(bodyPartName: String, navHostController: NavHostController, viewModel: ExercisesViewModel = hiltViewModel()) {
    ExercisesByBodyPartContent(navHostController,bodyPartName)
}