package com.example.domain.repo

import com.example.domain.dto.bodyPartList.BodyPartListResponse

interface BodyPartListRepo {
    suspend fun getBodyPartList(): BodyPartListResponse
}