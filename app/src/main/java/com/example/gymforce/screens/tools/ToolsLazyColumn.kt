package com.example.gymforce.screens.tools

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToolsLazyColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp)
    ) {
        items(1) {

        }
    }
}