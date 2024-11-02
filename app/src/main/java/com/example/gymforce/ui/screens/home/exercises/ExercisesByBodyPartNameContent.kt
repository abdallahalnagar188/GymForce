package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.example.domain.dto.exercises.ExercisesResponseItem

@Composable
fun ExercisesByBodyPartContent(
    navHostController: NavHostController,
    bodyPartName: String,
    exercises: LazyPagingItems<ExercisesResponseItem>,
    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar(
            navHostController = navHostController,
            partBodyName = bodyPartName
        )

        // Display exercises in a LazyColumn
        ExercisesLazyColumn(exercises = exercises, onClick = {exerciseId->
            navHostController.navigate("ExerciseDetailsScreen/$exerciseId")
        } )
    }
}
