package com.example.c001apk

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.c001apk.util.PrefManager

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        context = applicationContext

        AppCompatDelegate.setDefaultNightMode(PrefManager.darkTheme)
        //DynamicColors.applyToActivitiesIfAvailable(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }



}