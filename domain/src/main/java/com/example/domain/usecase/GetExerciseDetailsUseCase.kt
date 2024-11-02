package com.example.domain.usecase

import com.example.domain.repo.ExerciseDetailsRepo

class GetExerciseDetailsUseCase(private val exerciseDetailsRepo: ExerciseDetailsRepo) {
    suspend operator fun invoke(id: String) = exerciseDetailsRepo.getExerciseDetails(id)
}