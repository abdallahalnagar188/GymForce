package com.example.domain.usecase

import com.example.domain.repo.BodyPartListRepo

class GetBodyPartListUseCase(private val bodyPartListRepo: BodyPartListRepo) {
    suspend operator fun invoke( ) = bodyPartListRepo.getBodyPartList()

}