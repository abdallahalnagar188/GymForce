package com.example.gymforce.ui.screens.home.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.fontBold

@Composable
fun AppBar(navHostController: NavHostController, onBackClicked: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = colorResource(R.color.black_low))
    ) {
        IconButton(
            onClick = { onBackClicked() },
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(130.dp)) // This pushes the text to the right

        Text(
            text = "GymForce",
            color = Color.White,
            fontFamily = fontBold,
            fontSize = 16.sp,
            style = androidx.compose.material.MaterialTheme.typography.h6,
            modifier = Modifier
                .weight(1f) // This centers the text within the Row
                .align(Alignment.CenterVertically)
        )
    }
}
