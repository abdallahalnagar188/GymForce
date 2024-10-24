package com.example.domain.repo

import com.example.domain.models.User
import com.google.firebase.auth.FirebaseUser

// Domain Layer: AuthRepository.kt
interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<FirebaseUser?>
    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        weight: Double,
        height: Double
    ): Result<FirebaseUser?>
    suspend fun signOut(): Result<Unit>
    fun getCurrentUser(): FirebaseUser?
    suspend fun addUserToFirestore(user: User): Result<Unit>
}
