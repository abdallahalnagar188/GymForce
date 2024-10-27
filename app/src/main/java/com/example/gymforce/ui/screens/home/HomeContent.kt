package com.example.gymforce.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.gymforce.R
import com.example.gymforce.common.UiState
import com.example.gymforce.common.fontMedium
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.screens.home.bodyPart.BodyPartLazyColumn

@Composable
fun HomeContent(
    navHostController: NavHostController,
    bodyPartList: UiState<BodyPartListResponse>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeAppBar(navHostController, ivProfileId = R.drawable.ic_proflle )
        Spacer(modifier = Modifier.height(10.dp))
        when (bodyPartList) {
            is UiState.Loading -> {
               CircularProgressAnimated(Modifier.size(50.dp))
            }
            is UiState.Success -> {
                val exercises = bodyPartList.data

                BodyPartLazyColumn(bodyPartList = exercises?: emptyList(), onClick = {
                    navHostController.navigate("ExercisesByBodyPartScreen/${it}")
                })

            }
            is UiState.Error -> {
                // Show error message if data loading fails
                Text(
                    text = "Error: ${bodyPartList.message}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontFamily = fontMedium
                )
            }
            is UiState.Empty -> {
                // Show empty state message if no data is available
                Text(
                    text = "No exercises available.",
                    fontSize = 20.sp,
                    color = Color.Gray,
                    fontFamily = fontMedium
                )
            }
        }
    }
}
