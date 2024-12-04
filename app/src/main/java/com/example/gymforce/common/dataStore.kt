package com.example.gymforce.common

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.models.User
import com.google.gson.Gson
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_preferences")

object UserPreferences {
    val USER_DATA = stringPreferencesKey("user_data")
}

class UserCacheManager(private val context: Context) {

    private val gson = Gson()

    private var cachedUserData: User? = null

    val cachedUser = context.dataStore.data.map { prefs ->
        prefs[UserPreferences.USER_DATA]?.let { json ->
            gson.fromJson(json, User::class.java)
        }
    }

    suspend fun saveUser(user: User) {
        context.dataStore.edit { prefs ->
            prefs[UserPreferences.USER_DATA] = gson.toJson(user)
        }
        cachedUserData = user // Update the in-memory cache
    }

    suspend fun clearUser() {
        context.dataStore.edit { prefs ->
            prefs.remove(UserPreferences.USER_DATA)
        }
        cachedUserData = null
    }

    suspend fun loadUser() {
        // Load the user into memory on app launch
        cachedUser.firstOrNull()?.let {
            cachedUserData = it
        }
    }

    fun getCachedUser(): User? = cachedUserData
}

