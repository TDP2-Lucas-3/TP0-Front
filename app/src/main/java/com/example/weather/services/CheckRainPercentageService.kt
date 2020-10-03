package com.example.weather.services

import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat
import com.example.weather.MainActivity
import com.example.weather.R
import com.example.weather.models.RainCheck
import com.example.weather.repositories.ForecastRepository
import com.example.weather.support.NotificationBuilder

class CheckRainPercentageService {
    fun run(context: Context) {
        val rainOverThreshold = isRainOverThreshold(context)

        if (!rainOverThreshold) {
            return
        }

        sendRainNotification(context)

    }

    private fun sendRainNotification(context: Context) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val notification = NotificationBuilder(context, CHANNEL_ID)
            .build(intent)

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID, notification)
        }
    }

    private fun isRainOverThreshold(context: Context): Boolean {
        val threshold = context
            .getSharedPreferences(
                context.getString(
                    R.string.RAIN_PERCENTAGE_THRESHOLD
                ),
                Context.MODE_PRIVATE
            )
            .getInt(context.getString(R.string.RAIN_PERCENTAGE_THRESHOLD), 0)

        return RainCheck(threshold, ForecastRepository()).isOverThreshold()
    }

    companion object {
        private const val NOTIFICATION_ID = 0
        private const val CHANNEL_ID = "WEATHER"
    }
}