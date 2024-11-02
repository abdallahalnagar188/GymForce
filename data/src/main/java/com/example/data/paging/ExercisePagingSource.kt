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
        val currentPage = params.key ?: 1
        return try {
            // Fetch the data from the API
            val response = apiService.getExercises(
                bodyPart = bodyPart,
                limit = params.loadSize,
                offset = (currentPage - 1) * params.loadSize
            )

            // Create the LoadResult.Page with data
            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.isEmpty()) null else currentPage + 1
            )
        } catch (exception: Exception) {
            // Return an error result in case of any exception
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ExercisesResponseItem>): Int? {
        // Find the key of the page that is closest to the most recently accessed position
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

