package com.example.gymforce.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.gymforce.R
import com.example.gymforce.common.fontBold
import com.example.gymforce.common.fontMedium

@Composable
fun OnboardingPageScreen(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(page.animationRes))

        // Display the Lottie animation
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(260.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = page.title,
            style = MaterialTheme.typography.h5,
            fontFamily = fontBold,
            color = colorResource(R.color.white)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = page.description,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            fontFamily = fontMedium,
            color = colorResource(R.color.white)
        )
    }
}
