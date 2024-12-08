package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.meals.CategoryResponse
import com.example.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService) : MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}