package com.example.gymforce.di

import com.example.data.repoImpl.FirebaseAuthRepositoryImpl
import com.example.domain.repo.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// AppModule.kt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return FirebaseAuthRepositoryImpl(firebaseAuth, FirebaseFirestore.getInstance())
    }
     @Provides
     @Singleton
     fun provideFirestore(): FirebaseFirestore {
         return FirebaseFirestore.getInstance()
     }

}
