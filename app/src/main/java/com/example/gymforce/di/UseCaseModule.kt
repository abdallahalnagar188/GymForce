package com.example.gymforce.di

import com.example.domain.repo.BodyPartListRepo
import com.example.domain.repo.ExerciseDetailsRepo
import com.example.domain.repo.ExercisesRepo
import com.example.domain.usecase.GetBodyPartListUseCase
import com.example.domain.usecase.GetExerciseDetailsUseCase
import com.example.domain.usecase.GetExercisesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetExercisesUseCase(exercisesRepo: ExercisesRepo): GetExercisesUseCase {
        return GetExercisesUseCase(exercisesRepo)
    }

    @Provides
    @Singleton
    fun provideGetBodyPartListUseCase(bodyPartListRepo: BodyPartListRepo): GetBodyPartListUseCase {
        return GetBodyPartListUseCase(bodyPartListRepo)
    }
    @Provides
    @Singleton
    fun provideGetExerciseDetailsUseCase(exerciseDetailsRepo: ExerciseDetailsRepo): GetExerciseDetailsUseCase {
        return GetExerciseDetailsUseCase(exerciseDetailsRepo)
    }

}