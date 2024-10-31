package com.example.gymforce.ui.screens.home.exercises

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.dto.exercises.ex2.ExercisesResponseItem
import com.example.domain.usecase.GetExercisesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val exercisesUseCase: GetExercisesUseCase,
) : ViewModel() {

    // StateFlow to hold the PagingData
    private val _exercisesFlow = MutableStateFlow<PagingData<ExercisesResponseItem>>(PagingData.empty())
    val exercisesFlow: StateFlow<PagingData<ExercisesResponseItem>> get() = _exercisesFlow

    // Function to fetch exercises
    fun fetchExercises(bodyPart: String) {
        viewModelScope.launch {
            exercisesUseCase(bodyPart)
                .cachedIn(viewModelScope)
                .collect { pagingData ->
                    _exercisesFlow.value = pagingData
                }
        }
    }
}
