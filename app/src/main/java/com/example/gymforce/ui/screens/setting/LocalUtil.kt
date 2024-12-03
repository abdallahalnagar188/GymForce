package com.example.gymforce.ui.screens.setting

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import java.util.Locale

object LocalUtil {
    private const val PREFS_NAME = "language_prefs"
    private const val KEY_LANGUAGE = "language"
    private lateinit var preferences: SharedPreferences

    fun initPreferences(context: Context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun loadSavedLanguage(): String {
        return preferences.getString(KEY_LANGUAGE, "ar") ?: "ar" // Default to Arabic
    }

    fun setLanguage(context: Context, languageCode: String) {
        preferences.edit().putString(KEY_LANGUAGE, languageCode).apply()
        updateResources(context, languageCode)
    }

    fun updateResources(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        context.applicationContext.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}
