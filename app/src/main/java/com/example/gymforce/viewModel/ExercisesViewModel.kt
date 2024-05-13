package com.example.gymforce.viewModel

import androidx.lifecycle.ViewModel
import com.example.gymforce.models.listOfExercises

class ExercisesViewModel() : ViewModel() {
    fun getExercises() = listOfExercises
}