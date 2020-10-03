package com.example.weather.models

import com.example.weather.repositories.ForecastRepository

class RainCheck(val threshold: Int, val repository: ForecastRepository) {

    fun isOverThreshold() : Boolean {
        val forecast = repository.fetchForecast()

        return forecast.rain >= threshold
    }
}