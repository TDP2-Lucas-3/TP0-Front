package com.example.weather.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.weather.errors.AppError
import com.example.weather.errors.NetworkError
import com.example.weather.exceptions.NetworkErrorException
import com.example.weather.fragments.WeatherDisplayFragment
import com.example.weather.models.Forecast
import com.example.weather.repositories.ForecastRepository

class ForecastViewModel : ViewModel() {
    private val error: MutableLiveData<AppError> by lazy {
        MutableLiveData<AppError>()
    }

    fun fetchForecast(): Forecast? {
        try {
            return ForecastRepository().fetchForecast()
        } catch (error: NetworkErrorException) {
            this.error.postValue(NetworkError())
        } catch (error: Exception) {
            Log.i("Forecast", error.message!!)
        }

        return null;
    }

    fun subscribeToError(fragment: WeatherDisplayFragment, observer: Observer<AppError>) {
        error.observe(fragment, observer)
    }
}