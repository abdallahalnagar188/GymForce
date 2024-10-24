package com.example.gymforce.ui.commonUi

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.gymforce.R

@Composable
 fun CircularProgressAnimated(modifier: Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(animation = tween(900)),
        label = ""
    )
    CircularProgressIndicator(
        progress = progressAnimationValue,
        color = colorResource(id = R.color.green),
        modifier = modifier
    )
}