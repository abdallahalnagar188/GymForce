package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.repo.ExerciseDetailsRepo

class ExerciseDetailsRepoImpl(private val apiService: ApiService) : ExerciseDetailsRepo {
    override suspend fun getExerciseDetails(id: String) = apiService.getExerciseDetails(id)
}