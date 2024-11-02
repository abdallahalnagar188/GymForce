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
fun CircularProgressAnimated(
    modifier: Modifier = Modifier,
    colorId: Int = R.color.green,
    animationDurationMillis: Int = 900
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDurationMillis)
        ), label = ""
    )

    CircularProgressIndicator(
        progress = progressAnimationValue,
        color = colorResource(id = colorId),
        modifier = modifier
    )
}
