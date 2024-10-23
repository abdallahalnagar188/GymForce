package com.example.data.remote

import com.example.domain.dto.ExercisesResponseItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("exercises/bodyPart/{bodyPart}")
    suspend fun getPosts(
        @Path("bodyPart") bodyPart: String,
        @Query("x-rapidapi-key") apiKey: String
    ): List<ExercisesResponseItem>

}