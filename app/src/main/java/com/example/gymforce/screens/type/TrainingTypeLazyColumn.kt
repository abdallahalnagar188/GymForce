package com.example.gymforce.screens.type

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.models.TrainingTypeItem

@Composable
fun TrainingTypeLazyColumn(navHostController: NavHostController) {
    val list =  listOf(
        TrainingTypeItem(R.drawable.chest,"Training a"),
        TrainingTypeItem(R.drawable.chest,"Training b"),
        TrainingTypeItem(R.drawable.chest,"Training c"),
        TrainingTypeItem(R.drawable.chest,"Training d"),
        TrainingTypeItem(R.drawable.chest,"Training e"),
        TrainingTypeItem(R.drawable.chest,"Training f")
    )
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp)
    ) {
        item {
            list.forEach { item ->
                TrainingTypeCard(
                    name = item.nameOfTraining,
                    image = item.image,
                    navHostController
                )
            }
        }
    }

}