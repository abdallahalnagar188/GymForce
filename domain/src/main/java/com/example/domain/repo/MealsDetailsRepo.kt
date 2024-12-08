package com.example.domain.repo

import com.example.domain.dto.mealDetails.MealsDetailsResponse
import com.example.domain.dto.meals.CategoryResponse

interface MealsDetailsRepo {
   suspend fun getMealsDetails(id: String): MealsDetailsResponse
}