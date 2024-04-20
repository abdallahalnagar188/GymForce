package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gymforce.R

@Composable
fun ExercisesLazyColumn() {
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ){
        items(6){
            TrainingCard(name = "Chest Day ", day ="Day 1" , image =R.drawable.icon_app )
        }

    }
}