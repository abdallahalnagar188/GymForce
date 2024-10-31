package com.example.domain.dto.exercises.ex2

import com.google.gson.annotations.SerializedName

data class ExercisesResponse(

	@field:SerializedName("ExercisesResponse")
	val exercisesResponse: List<ExercisesResponseItem>? = null
)

data class ExercisesResponseItem(

	@field:SerializedName("gifUrl")
	val gifUrl: String? = null,

	@field:SerializedName("instructions")
	val instructions: List<String?>? = null,

	@field:SerializedName("secondaryMuscles")
	val secondaryMuscles: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("equipment")
	val equipment: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("bodyPart")
	val bodyPart: String? = null,

	@field:SerializedName("target")
	val target: String? = null
)
