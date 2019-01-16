package com.jurgielewicz.forecastapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.jurgielewicz.forecastapp.module.AppModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, AppModule().app)
        Stetho.initializeWithDefaults(this)

    }
}