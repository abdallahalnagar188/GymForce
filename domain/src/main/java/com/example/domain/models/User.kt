package com.example.domain.models

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val gender: String = "",
    val age: Int = 0,
    val userType: String = "",
//    val healthProblem: String? = null ,// Add this line for the photo URL,
//    val problemToSolve: String? = null // Add this line for the photo URL,
)
