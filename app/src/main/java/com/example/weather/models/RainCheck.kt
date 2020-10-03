package com.example.weather.models

import android.util.Log
import com.example.weather.repositories.ForecastRepository
import java.lang.Exception

class RainCheck(val threshold: Int, val repository: ForecastRepository) {

    fun isOverThreshold() : Boolean {
        try {
            val forecast = repository.fetchForecast()

            return forecast.rain >= threshold
        } catch (e: Exception) {
            Log.i("RainPercentageService", "Error requesting weather info$e")
            return false
        }
    }
}