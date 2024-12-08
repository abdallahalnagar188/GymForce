package com.example.gymforce.ui.screens.meals

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.dto.filterByCategory.FilterByCategoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.domain.dto.meals.CategoryResponse
import com.example.domain.usecase.GetFilterByCategory
import com.example.domain.usecase.GetMealz
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealzUseCase: GetMealz,
    private val getFilterByCategoryUseCase: GetFilterByCategory
) : ViewModel() {

    private val _meals: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val meals: StateFlow<CategoryResponse?> = _meals

    private val _filterByCategory: MutableStateFlow<FilterByCategoryResponse?> = MutableStateFlow(null)
    val filterByCategory: StateFlow<FilterByCategoryResponse?> = _filterByCategory

    suspend fun getMeals() {
        try {
            _meals.value = getMealzUseCase()
        } catch (e: Exception) {
            Log.e("MealsViewModel", e.message.toString())
        }
    }

    suspend fun getFilterByCategory(category: String) {
        try {
            _filterByCategory.value = getFilterByCategoryUseCase(category)
            Log.e("MealsViewModel", _filterByCategory.value.toString())
        } catch (e: Exception) {
            Log.e("MealsViewModel", e.message.toString())
        }
    }
}
