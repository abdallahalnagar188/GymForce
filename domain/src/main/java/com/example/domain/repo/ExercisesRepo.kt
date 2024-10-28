package com.example.domain.repo

import androidx.paging.PagingData
import com.example.domain.dto.exercises.ExercisesResponseItem
import kotlinx.coroutines.flow.Flow

interface ExercisesRepo {
     fun getExercisesPaged(bodyPart: String): Flow<PagingData<ExercisesResponseItem>>
}
