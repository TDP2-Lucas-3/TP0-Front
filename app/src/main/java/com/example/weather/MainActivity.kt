package com.example.weather

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.services.CheckRainPercentageReceiver
import com.example.weather.support.RepeatingAlarm

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, CheckRainPercentageReceiver::class.java)
        intent.action = WeatherDefaults.ACTION_PERIODIC_RAIN_CHECK

        RepeatingAlarm().setup(
            this,
            intent,
            AlarmManager.INTERVAL_FIFTEEN_MINUTES
        )

        setContentView(R.layout.activity_main)

    }
}