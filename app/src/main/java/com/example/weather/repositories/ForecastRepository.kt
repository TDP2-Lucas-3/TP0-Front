package com.example.weather.repositories

import com.example.weather.apis.ForecastAPI
import com.example.weather.exceptions.NetworkErrorException
import com.example.weather.models.Forecast
import com.example.weather.support.HttpClient

class ForecastRepository {
    private val API = HttpClient().getAPI(ForecastAPI::class.java)

    fun fetchForecast(): Forecast {
        var forecast: Forecast? = null
        try {
            forecast = API.getWeather().execute().body()
        } finally {
            if (forecast != null) {
                return forecast;
            }

            throw NetworkErrorException()
        }
    }
}