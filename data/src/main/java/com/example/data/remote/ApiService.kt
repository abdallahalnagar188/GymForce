package com.example.data.remote

import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ExercisesResponseItem
import com.example.domain.dto.exercises_details.ExerciseDetailsResponse
import com.example.domain.dto.filterByCategory.FilterByCategoryResponse
import com.example.domain.dto.mealDetails.MealsDetailsResponse
import com.example.domain.dto.meals.CategoryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("exercises/bodyPartList")
    suspend fun getBodyPartList(
    ): BodyPartListResponse

    @GET("exercises/bodyPart/{bodyPart}")
    suspend fun getExercises(
        @Path("bodyPart") bodyPart: String,
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): List<ExercisesResponseItem>

    @GET("exercises/exercise/{id}")
    suspend fun getExerciseDetails(
        @Path("id") id: String
    ): ExerciseDetailsResponse


    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): FilterByCategoryResponse


    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ): MealsDetailsResponse


}