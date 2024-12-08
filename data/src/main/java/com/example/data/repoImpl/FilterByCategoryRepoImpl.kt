package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.filterByCategory.FilterByCategoryResponse
import com.example.domain.repo.FilterByCategoryRepo

class FilterByCategoryRepoImpl(private val apiService: ApiService) : FilterByCategoryRepo {
    override suspend fun getFilterByCategory(category: String): FilterByCategoryResponse {
        return apiService.getMealsByCategory(category)
    }
}