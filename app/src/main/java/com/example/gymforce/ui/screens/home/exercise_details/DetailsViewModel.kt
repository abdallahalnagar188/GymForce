package com.example.gymforce.ui.screens.home.exercise_details

import com.example.domain.usecase.GetExerciseDetailsUseCase
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val detailsUseCase: GetExerciseDetailsUseCase
){
    suspend fun getExerciseDetails(id: String) = detailsUseCase(id)

}