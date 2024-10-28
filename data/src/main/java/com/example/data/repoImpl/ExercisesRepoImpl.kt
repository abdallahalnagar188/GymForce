package com.example.data.repoImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.paging.ExercisePagingSource
import com.example.data.remote.ApiService
import com.example.domain.dto.exercises.ExercisesResponseItem
import com.example.domain.repo.ExercisesRepo
import kotlinx.coroutines.flow.Flow

class ExercisesRepoImpl(private val apiService: ApiService) : ExercisesRepo {

    override  fun getExercisesPaged(bodyPart: String): Flow<PagingData<ExercisesResponseItem>> {
        return Pager(PagingConfig(pageSize = 10)) {
            ExercisePagingSource(apiService, bodyPart)
        }.flow
    }
}
