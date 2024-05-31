package com.example.gymforce.screens.tools


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.gymforce.R

@Composable
fun ToolsContent(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.bg_2),
            contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolsTopBAr()
    }
}
