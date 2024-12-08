package com.example.gymforce.di

import android.app.Application
import com.example.gymforce.common.LocalUtil
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GymForceApp:Application(){
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        LocalUtil.init(this)
    }
}