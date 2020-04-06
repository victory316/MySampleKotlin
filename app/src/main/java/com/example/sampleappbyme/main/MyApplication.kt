package com.example.sampleappbyme.main

import android.app.Application
import com.example.sampleappbyme.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication: Application() {

    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        super.onCreate()
    }
}