package com.example.weather.support

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import com.example.weather.R
import com.example.weather.WeatherDefaults
import com.example.weather.services.CheckRainPercentageReceiver

class RainCheckAlarmSetup {
    fun setup(context: Context) {
        val checkRainIntent = Intent(context, CheckRainPercentageReceiver::class.java)
        checkRainIntent.action = WeatherDefaults.ACTION_PERIODIC_RAIN_CHECK

        RepeatingAlarm().setup(
            context,
            checkRainIntent,
            AlarmManager.INTERVAL_FIFTEEN_MINUTES
        )

        val rainPreference = context.getSharedPreferences(
            context.getString(R.string.RAIN_PERCENTAGE_THRESHOLD),
            Context.MODE_PRIVATE
        )

        val rainCheckKey = context.getString(R.string.RAIN_PERCENTAGE_THRESHOLD)
        if (rainPreference.contains(rainCheckKey)) {
            return
        }

        // Set default if it doesn't exist
        with(rainPreference.edit()) {
            putInt(
                rainCheckKey,
                WeatherDefaults.RAIN_THRESHOLD
            )
            apply()
        }
    }
}