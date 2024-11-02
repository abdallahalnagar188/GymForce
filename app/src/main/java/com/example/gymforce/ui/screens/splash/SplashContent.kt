package com.example.gymforce.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.gymforce.R

@Composable
fun SplashContent() {
    // Load Lottie animation from the raw resource directory
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.amimation_for_splash))

    // Set up the progress for the animation, loop indefinitely
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.baby_blue)),
        contentAlignment = Alignment.Center // Center the content in the Box
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(260.dp).background(color = colorResource(id = R.color.transparent))
            .align(Alignment.Center)
        )
    }
}

