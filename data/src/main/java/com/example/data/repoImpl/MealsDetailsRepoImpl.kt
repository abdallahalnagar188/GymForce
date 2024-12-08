package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.mealDetails.MealsDetailsResponse
import com.example.domain.dto.meals.CategoryResponse
import com.example.domain.repo.MealsDetailsRepo
import com.example.domain.repo.MealsRepo

class MealsDetailsRepoImpl(private val apiService: ApiService) : MealsDetailsRepo {
    override suspend fun getMealsDetails(id: String): MealsDetailsResponse {
        return apiService.getMealDetails(id)
    }
}