package com.example.domain.dto.exercises_details

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ExerciseDetailsResponse(

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
) : Parcelable