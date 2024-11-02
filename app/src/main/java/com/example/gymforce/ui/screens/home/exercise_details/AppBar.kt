package com.example.gymforce.ui.screens.home.exercise_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.typography
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
fun AppBar(
    navHostController: NavHostController,
    exerciseId: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween, // Distribute items with space between
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = colorResource(R.color.black_low))
            .padding(horizontal = 8.dp) // Add padding if needed
    ) {
        // Back Icon Button
        IconButton(
            onClick = { navHostController.popBackStack() },
            modifier = Modifier.size(40.dp) // Adjust size for balance
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                tint = Color.White
            )
        }

        // Centered Text
        Box(
            modifier = Modifier
                .weight(1f) // Center in Row
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = exerciseId,
                color = Color.White,
                fontFamily = fontBold,
                fontSize = 18.sp,
                style = typography.h6,
            )
        }

        // Empty Spacer to balance Row layout
        Spacer(modifier = Modifier.size(40.dp))
    }
}

