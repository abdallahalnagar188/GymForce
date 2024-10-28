package com.example.gymforce.ui.screens.home.exercises

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.gymforce.common.fontMedium

@Composable
fun ExercisesByBodyPartContent(navHostController: NavHostController, bodyPartName: String, viewModel: ExercisesViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppBar(
            navHostController = navHostController,
            partBodyName = bodyPartName
        )
        val exercises = viewModel.getExercises(bodyPartName).collectAsLazyPagingItems()
        ExercisesLazyColumn(exercises = exercises, navHostController)
        Log.e("TAG", "ExercisesByBodyPartContent: $exercises")

    }

}