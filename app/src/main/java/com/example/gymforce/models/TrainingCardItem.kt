package com.example.gymforce.models

import com.example.gymforce.R

sealed class TrainingCardItem(
    var numOfDay: String,
    var workOutName: String,
    var workOutImage: Int
) {

    data object ChestDay : TrainingCardItem("Day 1", "Chest", R.drawable.icon_app)
    data object BackDay : TrainingCardItem("Day 2", "Back", R.drawable.icon_app)
    data object ShoulderDay : TrainingCardItem("Day 3", "Shoulder", R.drawable.icon_app)
    data object ArmsDay : TrainingCardItem("Day 4", "Arms", R.drawable.icon_app)
    data object LegDay : TrainingCardItem("Day 5", "Leg", R.drawable.icon_app)
    data object Off : TrainingCardItem("Day 6", "Off", R.drawable.icon_app)
}