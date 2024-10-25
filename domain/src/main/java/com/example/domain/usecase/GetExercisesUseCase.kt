package com.example.domain.usecase

import com.example.domain.dto.exercises.ExercisesResponse
import com.example.domain.repo.ExercisesRepo

class GetExercisesUseCase(private val exercisesRepo: ExercisesRepo) {
    suspend operator fun invoke( bodyPart: String) = exercisesRepo.getExercises( bodyPart)

}