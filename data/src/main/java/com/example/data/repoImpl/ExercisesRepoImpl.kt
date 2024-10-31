package com.example.data.repoImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.paging.ExercisePagingSource
import com.example.data.remote.ApiService
import com.example.domain.dto.exercises.ex2.ExercisesResponseItem
import com.example.domain.repo.ExercisesRepo
import kotlinx.coroutines.flow.Flow

class ExercisesRepoImpl(
    private val apiService: ApiService
) : ExercisesRepo {

    override suspend fun getExercisesPaged(bodyPart: String): Flow<PagingData<ExercisesResponseItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10, // The size of each page of data
                enablePlaceholders = false // Disable placeholders if not needed
            ),
            pagingSourceFactory = { ExercisePagingSource(apiService, bodyPart) }
        ).flow // This converts the Pager into a Flow of PagingData
    }
}