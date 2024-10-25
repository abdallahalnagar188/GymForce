package com.example.gymforce.di

import com.example.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://exercisedb.p.rapidapi.com/"
    private const val RAPIDAPI_KEY = "7a65a09525mshaf42380fc34ca7dp181720jsn51f33c3bc30f"
    private const val RAPIDAPI_HOST = "exercisedb.p.rapidapi.com"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val originalRequest: Request = chain.request()
            val requestWithHeaders = originalRequest.newBuilder()
                .addHeader("x-rapidapi-key", RAPIDAPI_KEY)
                .addHeader("x-rapidapi-host", RAPIDAPI_HOST)
                .build()
            chain.proceed(requestWithHeaders)
        }

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
