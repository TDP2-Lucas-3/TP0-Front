package com.example.weather.repositories

import com.example.weather.models.Forecast


class ForecastRepository {

    fun fetchForecast(): Forecast {
        return Forecast("cloudy", 15f, 10f);
    }
}