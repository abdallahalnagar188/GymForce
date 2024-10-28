package com.example.gymforce.ui.screens.home.exercises

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.bumptech.glide.Glide
import com.example.gymforce.R

@Composable
fun GlideImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            ImageView(context).apply {
                // Use Glide to load the image
                Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background) // Optional placeholder
                    .into(this)
            }
        },
        modifier = modifier
    )
}

@Composable
fun ExercisesCardItem(
    navHostController: NavHostController,
    exerciseName: String,
    exerciseImage: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.White,
            contentColor = androidx.compose.ui.graphics.Color.Black
        )
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
//            // Image on the left half
//            GlideImage(
//                imageUrl = exerciseImage,
//                modifier = Modifier
//                    .weight(1f) // 50% of the width
//                    .fillMaxSize()
//            )
            // Exercise name on the right half
            Box(
                modifier = Modifier
                    .weight(1f) // 50% of the width
                    .fillMaxSize()
            ) {
                // Add text or any other content here
                Text(
                    text = exerciseName,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

