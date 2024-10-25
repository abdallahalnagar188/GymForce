package com.example.domain.repo

import com.example.domain.dto.exercises.ExercisesResponse

interface ExercisesRepo {
    suspend fun getExercises(bodyPart:String): ExercisesResponse
}