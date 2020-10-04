package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weather.R
import com.example.weather.WeatherDefaults
import com.example.weather.models.Forecast

class BackgroundFragment : ForecastFragment() {
    private fun updateBackground(forecast: Forecast) {
        val newBackground = when {
            forecast.rain > WeatherDefaults.RAIN_THRESHOLD -> R.drawable.rain
            forecast.temp < WeatherDefaults.COLD_THRESHOLD -> R.drawable.cold
            else -> R.drawable.sunny
        }
        activity?.findViewById<ConstraintLayout>(R.id.container_layout)?.setBackgroundResource(newBackground)
    }

    override fun updateScreen(forecast: Forecast) {
        updateBackground(forecast)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.empty, container, false)
    }
}