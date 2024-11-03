package com.example.gymforce.common

import android.content.Context

object OnboardingPreferences {

    private const val PREFS_NAME = "app_prefs"
    private const val ONBOARDING_COMPLETED_KEY = "onboarding_completed"

    fun isOnboardingCompleted(context: Context): Boolean {
        val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return preferences.getBoolean(ONBOARDING_COMPLETED_KEY, false)
    }

    fun setOnboardingCompleted(context: Context) {
        val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        preferences.edit().putBoolean(ONBOARDING_COMPLETED_KEY, true).apply()
    }
}
