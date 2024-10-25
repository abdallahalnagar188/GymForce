package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.exercises.ExercisesResponse
import com.example.domain.repo.ExercisesRepo

class ExercisesRepoImpl(private val apiService: ApiService) : ExercisesRepo {
    override suspend fun getExercises( bodyPart: String): ExercisesResponse {
        return apiService.getExercises(bodyPart, )
    }
}