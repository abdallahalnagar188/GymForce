package com.example.gymforce.screens.type

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gymforce.models.TrainingCardItem

@Composable
fun TypeScreenContent(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally)
    {
        TypeScreenTopBar(trainingScreenName = TrainingCardItem.ChestDay.workOutName)


    }

}