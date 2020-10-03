package com.example.weather

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.example.weather.services.CheckRainPercentageService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAlarm()
        setContentView(R.layout.activity_main)
    }

    private fun setupAlarm() {
        Log.i("RainPercentageService", "Building Rain Percentage Service")

        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as? AlarmManager

        val intent = Intent(this, CheckRainPercentageService::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 123123, intent, 0)

        alarmManager?.setInexactRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + 10000,
            20000,
            pendingIntent
        )
    }
}