package com.example.gymforce.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gymforce.common.fontMedium

@Composable
fun ProfileScreenContent(
    userName: String,
    userHeight: String,
    userWeight: String,
    userImageUrl: String?,
    onSignOut: () -> Unit // Add the sign-out callback
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Display user information
        Text(text = userName, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        Text(text = userHeight, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        Text(text = userWeight, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        AsyncImage(
            model = userImageUrl,
            contentDescription = "User Image",
            modifier = Modifier.size(100.dp) // Set size for the image
        )

        // Sign Out Button
        Button(onClick = onSignOut) {
            Text("Sign Out", color = Color.White)
        }
    }
}
