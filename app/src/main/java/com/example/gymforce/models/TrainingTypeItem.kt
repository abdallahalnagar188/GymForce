package com.example.gymforce.models

import com.example.gymforce.R

sealed class TrainingTypeItem(
    val image: Int,
    val nameOfTraining: String
) {
    data object TrainingOne : TrainingTypeItem(R.drawable.chest, "train a")
    data object TrainingTwo : TrainingTypeItem(R.drawable.chest, "train b")
    data object TrainingThree : TrainingTypeItem(R.drawable.chest, "train c")
    data object TrainingFour : TrainingTypeItem(R.drawable.chest, "train d")
    data object TrainingFive : TrainingTypeItem(R.drawable.chest, "train e" )
    data object TrainingSex : TrainingTypeItem(R.drawable.chest, "train f")

}