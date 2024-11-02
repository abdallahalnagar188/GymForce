package com.example.domain.models

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val weight: Double = 0.0,
    val height: Double = 0.0,
    val photoUrl: String? = null // Add this line for the photo URL
)
