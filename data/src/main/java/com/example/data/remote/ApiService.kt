package com.example.data.remote

import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ExercisesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("exercises/bodyPartList")
    suspend fun getBodyPartList(
    ): BodyPartListResponse

    @GET("exercises/bodyPart/{bodyPart}")
    suspend fun getExercises(
        @Path("bodyPart") bodyPart: String,
    ): ExercisesResponse

}