package com.example.gymforce.models

import com.example.gymforce.R

sealed class TrainingCardItem(
    var numOfDay: String,
    var workOutName: String,
    var workOutImage: Int
) {

    data object ChestDay : TrainingCardItem("Day 1", "Chest", R.drawable.chest)
    data object BackDay : TrainingCardItem("Day 2", "Back", R.drawable.back)
    data object ShoulderDay : TrainingCardItem("Day 3", "Shoulder", R.drawable.shoulder)
    data object ArmsDay : TrainingCardItem("Day 4", "Arms", R.drawable.arms)
    data object LegDay : TrainingCardItem("Day 5", "Leg", R.drawable.legs)
    data object Off : TrainingCardItem("Day 6", "Off", R.drawable.resting)
}