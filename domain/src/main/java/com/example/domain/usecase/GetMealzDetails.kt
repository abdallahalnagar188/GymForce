package com.example.domain.usecase

import com.example.domain.repo.MealsDetailsRepo
import com.example.domain.repo.MealsRepo

class GetMealzDetails(private val mealsDetailsRepo: MealsDetailsRepo) {
    suspend operator fun invoke(id:String) = mealsDetailsRepo.getMealsDetails(id)
}