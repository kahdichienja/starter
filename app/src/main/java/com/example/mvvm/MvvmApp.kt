package com.example.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MvvmApp : Application(){
    override fun onCreate() {
        super.onCreate()

//        initTimber()
    }
}