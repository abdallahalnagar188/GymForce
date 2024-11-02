package com.example.domain.repo

import com.example.domain.dto.exercises_details.ExerciseDetailsResponse

interface ExerciseDetailsRepo {
    suspend fun getExerciseDetails(id: String): ExerciseDetailsResponse
}