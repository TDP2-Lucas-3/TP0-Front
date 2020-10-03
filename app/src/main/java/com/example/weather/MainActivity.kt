package com.example.weather

import android.app.AlarmManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.services.CheckRainPercentageService
import com.example.weather.support.RepeatingAlarm

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RepeatingAlarm().setup(
            this,
            CheckRainPercentageService::class.java,
            AlarmManager.INTERVAL_FIFTEEN_MINUTES
        )
        setContentView(R.layout.activity_main)
    }
}