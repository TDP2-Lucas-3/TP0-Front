package com.example.weather.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.models.Forecast
import com.example.weather.repositories.ForecastRepository

class ForecastViewModel : ViewModel() {
    val forecast = MutableLiveData<Forecast>();
    fun fetchForecast(): Forecast? {
        forecast.postValue(ForecastRepository().fetchForecast())
        return forecast.value;
    }
}