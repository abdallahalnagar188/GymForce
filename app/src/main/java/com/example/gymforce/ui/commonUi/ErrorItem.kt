package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorItem(message: String) {
    Text(text = "Error: $message", modifier = Modifier.fillMaxWidth(), color = androidx.compose.ui.graphics.Color.Red)
}
