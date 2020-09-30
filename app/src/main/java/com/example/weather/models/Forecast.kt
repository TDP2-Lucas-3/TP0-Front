package com.example.weather.models

class Forecast(val weather: String, val temperature: Float) {

    fun temperatureAsCelsiusStr(): String {
        return "${temperature.toInt()} ºC"
    }
}
