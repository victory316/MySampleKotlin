package com.example.sampleappbyme.main

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.sampleappbyme.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}