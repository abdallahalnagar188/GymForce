package com.example.data.repoImpl

import com.example.data.remote.ApiService
import com.example.domain.repo.BodyPartListRepo

class BodyPartListRepoImpl(private val apiService: ApiService) : BodyPartListRepo {
    override suspend fun getBodyPartList() = apiService.getBodyPartList()
}