package com.example.gymforce.models

import com.example.gymforce.R

sealed class TrainingCardItem(
    var numOfDay: String,
    var workOutName: String,
    var workOutImage: Int
) {

    data object ChestDay : TrainingCardItem("Day 1", "Chest", R.drawable.chest)
    data object backDay : TrainingCardItem("Day 2", "back", R.drawable.chest)
    data object sholderDay : TrainingCardItem("Day 3", "sholder", R.drawable.chest)
    data object armsDay : TrainingCardItem("Day 4", "arms", R.drawable.chest)
    data object legDay : TrainingCardItem("Day 5", "leg", R.drawable.chest)
    data object off : TrainingCardItem("Day 6", "off", R.drawable.chest)
}