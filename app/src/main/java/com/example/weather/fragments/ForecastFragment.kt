package com.example.weather.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.errors.AppError
import com.example.weather.models.Forecast
import com.example.weather.support.AsyncTask
import com.example.weather.support.Handler
import com.example.weather.viewmodels.ForecastViewModel

abstract class ForecastFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(ForecastViewModel::class.java)
    }

    protected abstract fun updateScreen(forecast: Forecast)

    protected open fun handleError(error: AppError) {
        Handler.handleError(activity!!, error)
    }

    private fun setupObservers() {
        val forecastObserver = Observer<Forecast> { forecast -> updateScreen(forecast) }
        viewModel.subscribeToForecast(this, forecastObserver)

        val errorObserver = Observer<AppError> { error -> handleError(error) }
        viewModel.subscribeToError(this, errorObserver)
    }

    protected fun fetchForecast() {
        AsyncTask.run { viewModel.fetchForecast() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
        fetchForecast()
    }
}