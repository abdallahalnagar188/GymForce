package com.example.domain.usecase

import com.example.domain.dto.filterByCategory.FilterByCategoryResponse
import com.example.domain.repo.FilterByCategoryRepo

class GetFilterByCategory(private val filterByCategoryRepo: FilterByCategoryRepo) {
    suspend operator fun invoke(category: String): FilterByCategoryResponse =
        filterByCategoryRepo.getFilterByCategory(category)
}