package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.ApiService
import com.example.domain.dto.exercises.ExercisesResponseItem

class ExercisePagingSource(
    private val apiService: ApiService,
    private val bodyPart: String
) : PagingSource<Int, ExercisesResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ExercisesResponseItem> {
        return try {
            val offset = params.key ?: 0
            val limit = params.loadSize
            val response = apiService.getExercises(bodyPart = bodyPart, limit = limit, offset = offset)

            LoadResult.Page(
                data = response, // Adjust based on your ExercisesResponse structure
                prevKey = if (offset == 0) null else offset - limit,
                nextKey = if (response.isEmpty()) null else offset + limit
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ExercisesResponseItem>): Int? {
        return null
//        state.anchorPosition?.let { anchorPosition ->
////            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(params.loadSize)
////                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(params.loadSize)
//        }
    }
}
