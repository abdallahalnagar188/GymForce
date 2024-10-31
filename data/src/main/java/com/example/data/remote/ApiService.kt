package com.example.data.remote

import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ex2.ExercisesResponse
import com.example.domain.dto.exercises.ex2.ExercisesResponseItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Call

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


}