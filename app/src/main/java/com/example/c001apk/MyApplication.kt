package com.example.c001apk

import android.app.Application
import com.example.c001apk.util.CookieUtil
import com.example.c001apk.util.TokenDeviceUtils
import com.example.c001apk.util.TokenDeviceUtils.Companion.getTokenV2
import com.google.android.material.color.DynamicColors
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        genData()
        requestData()

        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    private fun genData() {
        CookieUtil.deviceCode = TokenDeviceUtils.getLastingDeviceCode(this)
        CookieUtil.token = CookieUtil.deviceCode.getTokenV2()
    }

    private fun requestData() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://api.coolapk.com/v6/account/checkLoginInfo")
                    .addHeader("X-Requested-With", "XMLHttpRequest")
                    .addHeader("X-App-Id", "com.coolapk.market")
                    .build()
                val response = client.newCall(request).execute()
                val headers = response.headers
                val cookies = headers.values("Set-Cookie");
                val session = cookies[0]
                val sessionID = session.substring(0, session.indexOf(";"))
                CookieUtil.SESSID = sessionID
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}