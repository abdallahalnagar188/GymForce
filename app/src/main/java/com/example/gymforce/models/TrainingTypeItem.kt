package com.example.gymforce.models

import com.example.gymforce.R

sealed class TrainingTypeItem(
    val image: Int,
    val nameOfTraining: String
) {
    data object TrainingOne : TrainingTypeItem(R.drawable.chest, "incline pinch pres")
    data object TrainingTwo : TrainingTypeItem(R.drawable.chest, "incline pinch pres")
    data object TrainingThree : TrainingTypeItem(R.drawable.chest, "incline pinch pres")
    data object TrainingFour : TrainingTypeItem(R.drawable.chest, "incline pinch pres")
    data object TrainingFive : TrainingTypeItem(R.drawable.chest, "incline pinch pres")
    data object TrainingSex : TrainingTypeItem(R.drawable.chest, "incline pinch pres")

}