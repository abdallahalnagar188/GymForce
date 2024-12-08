package com.example.gymforce.di

import android.content.Context
import com.example.data.remote.ApiService
import com.example.data.repoImpl.BodyPartListRepoImpl
import com.example.data.repoImpl.ExerciseDetailsRepoImpl
import com.example.data.repoImpl.ExercisesRepoImpl
import com.example.data.repoImpl.FilterByCategoryRepoImpl
import com.example.data.repoImpl.FirebaseAuthRepositoryImpl
import com.example.data.repoImpl.MealsDetailsRepoImpl
import com.example.data.repoImpl.MealsRepoImpl
import com.example.domain.repo.AuthRepository
import com.example.domain.repo.BodyPartListRepo
import com.example.domain.repo.ExerciseDetailsRepo
import com.example.domain.repo.ExercisesRepo
import com.example.domain.repo.FilterByCategoryRepo
import com.example.domain.repo.MealsDetailsRepo
import com.example.domain.repo.MealsRepo
import com.example.gymforce.common.UserCacheManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ): AuthRepository {
        return FirebaseAuthRepositoryImpl(firebaseAuth, firestore)
    }

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideExercisesRepo(apiService: ApiService): ExercisesRepo {
        return ExercisesRepoImpl(apiService)

    }

    @Provides
    @Singleton
    fun provideBodyPartListRepo(apiService: ApiService): BodyPartListRepo {
        return BodyPartListRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideExerciseDetailsRepo(apiService: ApiService): ExerciseDetailsRepo {
        return ExerciseDetailsRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideUserCacheManager(@ApplicationContext context: Context): UserCacheManager {
        return UserCacheManager(context)

    }
    @Provides
    @Singleton
    fun provideRepo(apiService: ApiService): MealsRepo {
        return MealsRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideFoodByCategoryRepo(apiService: ApiService): FilterByCategoryRepo {
        return FilterByCategoryRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideMealsDetailsRepo(apiService: ApiService): MealsDetailsRepo {
        return MealsDetailsRepoImpl(apiService)
    }
}

