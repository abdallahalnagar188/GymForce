package com.example.gymforce.ui.screens.trainersScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gymforce.R
import com.example.gymforce.ui.commonUi.CustomAppBar

@Composable
fun TrainersScreenContent(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        CustomAppBar(
            navHostController = navHostController,
            title = stringResource(R.string.trainers)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TrainerList(trainers = generateRandomTrainers(10))
    }

}

@Preview
@Composable
fun TrainersScreenContentPreview() {
    TrainersScreenContent(navHostController = rememberNavController())
}
