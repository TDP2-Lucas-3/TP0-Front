package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.errors.AppError
import com.example.weather.models.Forecast
import com.example.weather.support.AsyncTask
import com.example.weather.support.Handler
import com.example.weather.viewmodels.ForecastViewModel


class WeatherDisplayFragment() : Fragment() {
    private var forecast: Forecast? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(ForecastViewModel::class.java)
    }

    private fun temperatureAsCelsiusStr(): String {
        return "${forecast?.temp?.toInt()} ºC"
    }

    private fun rainProbabilityStr(): String {
        return "${forecast?.rain}% lluvia"
    }

    private fun initialize() {
        forecast = viewModel.fetchForecast()
        view?.findViewById<TextView>(R.id.weatherText)?.text = temperatureAsCelsiusStr()
        view?.findViewById<TextView>(R.id.rainText)?.text = rainProbabilityStr()
    }

    private fun initializeError() {
        val errorObserver = Observer<AppError> { error -> handleError(error) }
        viewModel.subscribeToError(this, errorObserver)
    }

    private fun handleError(error: AppError) {
        Handler.handleError(activity!!, error)

        view?.findViewById<TextView>(R.id.weatherText)?.text = DEFAULT_ERROR_VALUE
        view?.findViewById<TextView>(R.id.rainText)?.text = DEFAULT_ERROR_VALUE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeError()
        AsyncTask.run { initialize() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_display, container, false)
    }

    companion object {
        private const val DEFAULT_ERROR_VALUE = "S/D"
    }
}