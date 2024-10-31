package com.example.domain.repo

import androidx.paging.PagingData
import com.example.domain.dto.exercises.ex2.ExercisesResponseItem
import kotlinx.coroutines.flow.Flow

interface ExercisesRepo {
     suspend fun getExercisesPaged(bodyPart: String): Flow<PagingData<ExercisesResponseItem>>
}
