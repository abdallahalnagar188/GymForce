package com.example.gymforce.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gymforce.R

@Composable
fun SplashContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.black_low)),
        contentAlignment = Alignment.Center // Center the content in the Box
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_lion),
            contentDescription = null, // Optional content description
            modifier = Modifier
                .size(160.dp) // Set the size of the image to 100dp
            , tint = colorResource(id = R.color.green)
        )
    }
}
