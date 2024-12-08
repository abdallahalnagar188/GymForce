package com.example.domain.repo

import com.example.domain.dto.filterByCategory.FilterByCategoryResponse

interface FilterByCategoryRepo {
   suspend fun getFilterByCategory(category: String): FilterByCategoryResponse
}