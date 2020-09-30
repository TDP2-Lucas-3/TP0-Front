package com.example.weather.repositories

import com.example.weather.models.Forecast
import com.example.weather.support.HttpClient


class ForecastRepository {
    private val httpClient: HttpClient = HttpClient()

    fun fetchForecast(): Forecast {
        httpClient.get("weather")
        return Forecast("cloudy", 15f, 10f);
    }
}