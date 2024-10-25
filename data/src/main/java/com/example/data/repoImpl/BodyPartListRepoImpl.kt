package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ExercisesResponse
import com.example.domain.repo.BodyPartListRepo
import com.example.domain.repo.ExercisesRepo

class BodyPartListRepoImpl(private val apiService: ApiService) : BodyPartListRepo {
    override suspend fun getBodyPartList(): BodyPartListResponse {
        return apiService.getBodyPartList()
    }
}