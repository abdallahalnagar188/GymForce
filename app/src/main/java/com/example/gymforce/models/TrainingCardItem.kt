package com.example.gymforce.models

import com.example.gymforce.R

sealed class TrainingCardItem(
    var numOfDay: String,
    var workOutName: String,
    var workOutImage: Int
) {

    data object ChestDay : TrainingCardItem("Day 1", "Chest", R.drawable.icon_app)
    data object BackDay : TrainingCardItem("Day 2", "back", R.drawable.icon_app)
    data object ShoulderDay : TrainingCardItem("Day 3", "shoulder", R.drawable.icon_app)
    data object ArmsDay : TrainingCardItem("Day 4", "arms", R.drawable.icon_app)
    data object LegDay : TrainingCardItem("Day 5", "leg", R.drawable.icon_app)
    data object Off : TrainingCardItem("Day 6", "off", R.drawable.icon_app)
}