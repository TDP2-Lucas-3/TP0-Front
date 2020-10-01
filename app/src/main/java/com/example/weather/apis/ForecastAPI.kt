package com.example.weather.apis

import com.example.weather.models.Forecast
import retrofit2.Call
import retrofit2.http.GET


interface ForecastAPI {
    @GET("weather/")
    fun getWeather(): Call<Forecast?>
}