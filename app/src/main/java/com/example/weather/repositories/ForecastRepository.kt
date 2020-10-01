package com.example.weather.repositories

import android.util.Log
import com.example.weather.apis.ForecastAPI
import com.example.weather.models.Forecast
import com.example.weather.support.HttpClient


class ForecastRepository {
    private val API = HttpClient().getAPI(ForecastAPI::class.java)

    fun fetchForecast(): Forecast {
        val forecast = API.getWeather().execute().body()

        if (forecast != null) {
            Log.i("Forecast", "Forecast fetched");
            return forecast;
        }

        throw Exception("Error en la API call")
    }
}