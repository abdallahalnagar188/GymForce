package com.example.gymforce.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.fontBold

@Composable
fun HomeAppBar(
    navHostController: NavHostController,
    onClick: () -> Unit = {},
    ivProfileId: Int,
    imageUrl: String? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween, // Space items apart
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = colorResource(R.color.black_low))
            .padding(horizontal = 8.dp) // Add horizontal padding if needed
    ) {
        // Profile Icon
        IconButton(
            onClick = { onClick() },
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.transparent),
                    shape = CircleShape
                )
                .size(36.dp) // Adjust size to balance padding and appearance
        ) {
            Icon(
                painter = painterResource(ivProfileId),
                contentDescription = "Image Profile",
                tint = Color.White,
            )
        }

        // Centered Text in Box
        Box(
            modifier = Modifier
                .weight(1f) // Use weight to center-align in Row
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "GymForce",
                color = Color.White,
                fontFamily = fontBold,
                fontSize = 16.sp,
                style = typography.h6,
            )
        }

        // Notifications Icon
        IconButton(
            onClick = { onClick() },
            modifier = Modifier
                .size(32.dp) // Adjust size for a balanced look
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Color.White
            )
        }
    }
}

