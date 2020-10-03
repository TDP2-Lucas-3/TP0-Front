package com.example.weather.support

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log

class RepeatingAlarm {

    fun setup(context: Context, intent: Intent, repeatingInterval: Long) {
        Log.i("RainPercentageService", "Building Rain Percentage Service")

        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            123123,
            intent,
            0
        )

        alarmManager?.setInexactRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + 10000,
            repeatingInterval,
            pendingIntent
        )
    }
}