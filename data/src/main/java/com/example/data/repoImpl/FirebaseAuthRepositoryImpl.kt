package com.example.data.repoImpl

import com.example.domain.models.User
import com.example.domain.repo.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// Data Layer: FirebaseAuthRepositoryImpl.kt
class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Result<FirebaseUser?> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(authResult.user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        weight: Double,
        height: Double
    ): Result<FirebaseUser?> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user

            user?.let {
                // Create User object
                val userData = User(
                    uid = it.uid,
                    name = name,
                    email = email,
                    weight = weight,
                    height = height
                )

                // Save user data to Firestore
                firestore.collection("users").document(it.uid).set(userData).await()
            }

            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    override suspend fun signOut(): Result<Unit> {
        return try {
            firebaseAuth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override suspend fun addUserToFirestore(user: User): Result<Unit> {

        return try {
            // Save user data to Firestore
            firestore.collection("users").document(user.uid).set(user).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
