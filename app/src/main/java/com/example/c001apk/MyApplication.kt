package com.example.c001apk

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.c001apk.constant.Constants
import com.example.c001apk.logic.model.CheckResponse
import com.example.c001apk.logic.model.LoginResponse
import com.example.c001apk.util.CookieUtil
import com.example.c001apk.util.PrefManager
import com.example.c001apk.util.TokenDeviceUtils
import com.example.c001apk.util.TokenDeviceUtils.Companion.getTokenV2
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.concurrent.thread

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