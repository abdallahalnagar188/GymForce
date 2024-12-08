package com.example.gymforce.common

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import java.util.Locale

object LocalUtil {
    private lateinit var sharedPreferences: SharedPreferences
    private const val LANGUAGE = "language"

    // Initialize the SharedPreferences
    fun init(context: Context) {
        sharedPreferences = context.applicationContext.getSharedPreferences("local", Context.MODE_PRIVATE)
    }

    // Load the saved language and apply it
    fun loadLocal(activity: Activity) {
        val language = sharedPreferences.getString(LANGUAGE, "en") ?: "en" // Default language is now "en"
        setLocale(activity, language)
    }

    // Get the currently saved language
    fun getLang(): String {
        return sharedPreferences.getString(LANGUAGE, "en") ?: "en" // Default language is "en"
    }

    // Check if the current language is English
    fun isEnglish(): Boolean {
        return getLang() == "en"
    }

    // Save the new language and update resources
    fun setLocal(activity: Activity, language: String) {
        sharedPreferences.edit().putString(LANGUAGE, language).apply()
        setLocale(activity, language)
        activity.recreate() // Recreate to apply changes
    }

    // Update the app's resources and layout direction safely
    private fun setLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.createConfigurationContext(config)
        } else {
            @Suppress("DEPRECATION")
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
    }
}
