package com.example.gymforce.di

import android.app.Application
import com.example.gymforce.ui.screens.setting.LocalUtil
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GymForceApp:Application(){
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        LocalUtil.initPreferences(this)
        LocalUtil.updateResources(this, LocalUtil.loadSavedLanguage())
    }
}