package com.example.gymforce.screens.type

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.models.TrainingCardItem

@Composable
fun TypeScreenContent(
    name: String,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally)
    {
        TypeScreenTopBar(
            navHostController = navHostController,
            trainingScreenName = name
        )
        TrainingTypeLazyColumn(navHostController = navHostController)
    }

}