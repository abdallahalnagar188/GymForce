package com.example.domain.usecase

import com.example.domain.repo.ExercisesRepo

class GetExercisesUseCase(private val exercisesRepo: ExercisesRepo) {
     operator fun invoke( bodyPart: String) = exercisesRepo.getExercisesPaged( bodyPart)
}