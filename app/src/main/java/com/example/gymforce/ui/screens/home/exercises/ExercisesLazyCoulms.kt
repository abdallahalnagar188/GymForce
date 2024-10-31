package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.domain.dto.exercises.ex2.ExercisesResponseItem
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.commonUi.ErrorItem

@Composable
fun ExercisesLazyColumn(
    exercises: LazyPagingItems<ExercisesResponseItem>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Show exercises or empty state
        if (exercises.itemCount > 0) {
            items(exercises.itemCount) { index ->
                val exerciseItem = exercises[index]
                exerciseItem?.let {
                    ExercisesCardItem(exerciseItem = it)
                }
            }

        } else if (exercises.loadState.refresh !is LoadState.Loading) {
            // Show a message when there are no items
            item { ErrorItem(message = "No exercises available.") }
        }

        // Handle loading and error states
        when {
            exercises.loadState.refresh is LoadState.Loading -> {
                item { CircularProgressAnimated(modifier = Modifier.size(30.dp)) }
            }
            exercises.loadState.append is LoadState.Loading -> {
                item { CircularProgressAnimated(modifier = Modifier.size(30.dp)) }
            }
            exercises.loadState.refresh is LoadState.Error -> {
                val error = exercises.loadState.refresh as LoadState.Error
                item { ErrorItem(message = error.error.localizedMessage ?: "Unknown error") }
            }
            exercises.loadState.append is LoadState.Error -> {
                val error = exercises.loadState.append as LoadState.Error
                item { ErrorItem(message = error.error.localizedMessage ?: "Unknown error") }
            }
        }
    }
}





