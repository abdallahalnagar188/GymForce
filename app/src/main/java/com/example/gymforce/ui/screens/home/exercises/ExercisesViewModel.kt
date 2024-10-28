package com.example.gymforce.ui.screens.home.exercises

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetExercisesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ExercisesResponse
import com.example.domain.dto.exercises.ExercisesResponseItem
import com.example.domain.usecase.GetBodyPartListUseCase
import com.example.gymforce.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ExercisesViewModel @Inject constructor(
private val exercisesUseCase: GetExercisesUseCase,
) : ViewModel() {

     fun getExercises(bodyPart: String): Flow<PagingData<ExercisesResponseItem>> {
        return exercisesUseCase(bodyPart).cachedIn(viewModelScope)
    }

}