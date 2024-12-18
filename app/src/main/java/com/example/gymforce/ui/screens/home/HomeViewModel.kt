package com.example.gymforce.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.bodyPartList.BodyPartListResponse
import com.example.domain.dto.exercises.ExercisesResponse
import com.example.domain.usecase.GetBodyPartListUseCase
import com.example.gymforce.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bodyPartUseCase: GetBodyPartListUseCase,
  //  private val exercisesUseCase: GetExercisesUseCase
) : ViewModel() {


    private val _exercises: MutableStateFlow<UiState<ExercisesResponse>> =
        MutableStateFlow(UiState.Empty)
    val exercises: StateFlow<UiState<ExercisesResponse>> get() = _exercises

    private val _bodyPartList: MutableStateFlow<UiState<BodyPartListResponse>> =
        MutableStateFlow(UiState.Empty)
    val bodyPartList: StateFlow<UiState<BodyPartListResponse>> get() = _bodyPartList
//
//    fun getExercises(bodyPart: String) {
//
//        viewModelScope.launch {
//            try {
//                _exercises.value = UiState.Loading
//                val response = exercisesUseCase(bodyPart)
//                _exercises.value = UiState.Success(response)
//
//                if (response.isEmpty()) {
//                    _exercises.value = UiState.Empty
//                }
//            } catch (e: Exception) {
//                _exercises.value = UiState.Error(e.message.toString())
//        }
//    }

    fun getBodyPartList() {
        viewModelScope.launch {
            try {
                _bodyPartList.value = UiState.Loading
                val response = bodyPartUseCase()

                _bodyPartList.value = UiState.Success(response)
                if (response.isEmpty()) {
                    _bodyPartList.value = UiState.Empty
                }
            } catch (e: Exception) {
                _bodyPartList.value = UiState.Error(e.message.toString())
            }
        }
    }
}