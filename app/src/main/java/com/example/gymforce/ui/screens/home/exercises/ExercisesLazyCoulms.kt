package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Center the content within the Box
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(), // Fill remaining space after progress bar
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Show exercises or empty state
            items(exercises.itemCount) { index ->
                val exerciseItem = exercises[index]
                exerciseItem?.let {
                    ExercisesCardItem(exerciseItem = it)
                }
            }

            if (exercises.loadState.refresh is LoadState.Loading || exercises.loadState.append is LoadState.Loading) {
                item {
                    // Center the progress bar within the LazyColumn
                    CircularProgressAnimated(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            // Handle error states as before
            if (exercises.loadState.refresh is LoadState.Error || exercises.loadState.append is LoadState.Error) {
                val error = if (exercises.loadState.refresh is LoadState.Error) {
                    exercises.loadState.refresh as LoadState.Error
                } else {
                    exercises.loadState.append as LoadState.Error
                }
                item { ErrorItem(message = error.error.localizedMessage ?: "Unknown error") }
            }
        }
    }
}