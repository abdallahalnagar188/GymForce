package com.example.gymforce.ui.screens.brainGym

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.gymforce.R
import com.example.gymforce.ui.screens.home.HomeAppBar

@Composable
fun BrainGymScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeAppBar(
            title = "Brain Gym"
        )
        ComingSoonAnimation()

    }
}

@Composable
fun ComingSoonAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coming_soon))

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
        Image(painter = painterResource(id = R.drawable.brain_bym_image), contentDescription = null)
    }
}