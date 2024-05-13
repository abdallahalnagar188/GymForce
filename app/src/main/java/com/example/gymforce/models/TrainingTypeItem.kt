package com.example.gymforce.models

import com.example.gymforce.R

data class TrainingTypeItem(
    val image: Int,
    val nameOfTraining: String
)
val listOfExercises =  listOf(
    TrainingTypeItem(R.drawable.chest,"Training a"),
    TrainingTypeItem(R.drawable.chest,"Training b"),
    TrainingTypeItem(R.drawable.chest,"Training c"),
    TrainingTypeItem(R.drawable.chest,"Training d"),
    TrainingTypeItem(R.drawable.chest,"Training e"),
    TrainingTypeItem(R.drawable.chest,"Training f")
)