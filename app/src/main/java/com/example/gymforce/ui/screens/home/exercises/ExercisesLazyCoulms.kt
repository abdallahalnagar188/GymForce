package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.example.domain.dto.exercises.ExercisesResponseItem

@Composable
fun ExercisesLazyColumn(
    exercises: LazyPagingItems<ExercisesResponseItem>,
    navHostController: NavHostController,

) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // Display each exercise as a card item
        items(exercises.itemCount) { index ->
            exercises[index]?.let { exercise ->
                ExercisesCardItem(
                    navHostController = navHostController,
                    exerciseName = exercise.name,  // Handle null case
                    exerciseImage = exercise.gifUrl             // Handle null case
                )
            }
        }

//
//        // Handle loading and error states
//        exercises.apply {
//            when {
//                loadState.refresh is LoadState.Loading -> {
//                    item { CircularProgressAnimated(modifier = Modifier.fillParentMaxWidth()) }
//                }
//                loadState.append is LoadState.Loading -> {
//                    item { CircularProgressAnimated(modifier = Modifier.fillParentMaxWidth()) }
//                }
//                loadState.refresh is LoadState.Error -> {
//                    val error = loadState.refresh as LoadState.Error
//                    item {
//                        Text("Error: ${error.error.localizedMessage}")
//                    }
//                }
//                loadState.append is LoadState.Error -> {
//                    val error = loadState.append as LoadState.Error
//                    item {
//                        Text("Error: ${error.error.localizedMessage}")
//                    }
//                }
//            }
//        }
    }
}


