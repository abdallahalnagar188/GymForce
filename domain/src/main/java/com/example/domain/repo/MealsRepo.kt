package com.example.domain.repo

import com.example.domain.dto.meals.CategoryResponse

interface MealsRepo {
   suspend fun getMealsFromRemote(): CategoryResponse
}