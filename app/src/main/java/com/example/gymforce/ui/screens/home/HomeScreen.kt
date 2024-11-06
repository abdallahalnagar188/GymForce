package com.example.gymforce.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()) {
    // Fetch data only once
    LaunchedEffect(Unit) {
        viewModel.getBodyPartList()
    }

    // Collect the state from the ViewModel
    val bodyPartList by viewModel.bodyPartList.collectAsState()


    // Pass the exercises data to ExercisesContent to render the UI based on the state
    HomeContent(navHostController, bodyPartList)

}

