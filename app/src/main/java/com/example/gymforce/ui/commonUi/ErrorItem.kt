package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorItem(message: String) {
    Text(text = "Error: $message", modifier = Modifier.fillMaxWidth(), color = Color.Red)
}
