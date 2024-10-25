package com.example.domain.repo

import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ExercisesResponse

interface BodyPartListRepo {
    suspend fun getBodyPartList(): BodyPartListResponse
}