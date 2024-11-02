package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.domain.dto.exercises.ExercisesResponseItem
import com.example.gymforce.common.fontMedium

@Composable
fun ExercisesCardItem(
    exerciseItem: ExercisesResponseItem,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier.clickable { onClick() }
            .fillMaxWidth()
            .height(140.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        ),
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Image on the left half
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(exerciseItem.gifUrl) // Load the first URL from the list
                    .size(1000) // You can adjust this to your desired size
                    .scale(Scale.FILL) // Adjust scaling as needed
                    .build(),
                contentDescription = "Exercise Image",
                modifier = Modifier
                    .weight(0.4f).fillMaxHeight()
            )
            // Exercise name on the right half
            Box(
                modifier = Modifier
                    .weight(0.6f) // 60% of the width
            ) {
                Text(
                    text = exerciseItem.name ?: "",
                    modifier = Modifier.padding(16.dp).align(Alignment.Center),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = fontMedium,
                )
            }
        }
    }
}
