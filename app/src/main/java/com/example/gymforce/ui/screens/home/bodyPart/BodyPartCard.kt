package com.example.gymforce.ui.screens.home.bodyPart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.example.gymforce.common.fontMedium

@Composable
fun BodyPartCard(
    bodyPartName: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .clickable { onClick() } // Entire card is clickable
            .padding(8.dp) // Padding around the card
            .border(
                width = 1.dp,
                color = White,
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Box(
            modifier = Modifier
                .background(color = colorResource(R.color.baby_blue))
                .padding(16.dp) // Padding inside the card
        ) {
            Text(
                text = bodyPartName,
                color = White,
                fontFamily = fontMedium,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center) // Center text in the card
            )
        }
    }
}

