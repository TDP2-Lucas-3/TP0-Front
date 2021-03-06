package com.example.weather.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_BOOT_COMPLETED
import android.util.Log
import com.example.weather.WeatherDefaults
import com.example.weather.support.AsyncTask

class CheckRainPercentageReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("RainPercentageService", "Running Rain Percentage Service")

        if (context == null || intent == null) {
            return
        }

        if (intent.action != WeatherDefaults.ACTION_PERIODIC_RAIN_CHECK) {
            return
        }
        AsyncTask.run {
            CheckRainPercentageService().run(context)
        }
    }

}