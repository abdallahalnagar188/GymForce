package com.example.gymforce.screens.tools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ToolsContent(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),Arrangement.Center) {
        Text(text = "Tools Screen")

    }

}