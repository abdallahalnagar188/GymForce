package com.example.gymforce.di

import com.example.domain.repo.BodyPartListRepo
import com.example.domain.repo.ExercisesRepo
import com.example.domain.usecase.GetBodyPartListUseCase
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

}