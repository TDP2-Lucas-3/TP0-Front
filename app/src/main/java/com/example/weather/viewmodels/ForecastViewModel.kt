package com.example.weather.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.models.Forecast
import com.example.weather.repositories.ForecastRepository

class ForecastViewModel : ViewModel() {
    fun fetchForecast(): Forecast? {
        return ForecastRepository().fetchForecast()
    }
}