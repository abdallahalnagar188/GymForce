package com.example.gymforce.ui.screens.trainersScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gymforce.ui.commonUi.CustomAppBar

@Composable
fun TrainersScreenContent(navHostController: NavHostController) {
Column(modifier = Modifier.fillMaxSize()){
    CustomAppBar(navHostController = rememberNavController(), title = "Trainers")
}

}

@Preview
@Composable
fun TrainersScreenContentPreview() {
    TrainersScreenContent(navHostController = rememberNavController())
}
