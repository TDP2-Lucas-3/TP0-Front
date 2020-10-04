package com.example.weather.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.errors.AppError
import com.example.weather.models.Forecast
import com.example.weather.support.AsyncTask
import com.example.weather.support.Handler
import com.example.weather.viewmodels.ForecastViewModel


class WeatherDisplayFragment : ForecastFragment() {
    private fun setupView(view: View) {
        view.findViewById<Button>(R.id.bRefresh).setOnClickListener { fetchForecast() }
    }

    override fun updateScreen(forecast: Forecast) {
        view?.findViewById<TextView>(R.id.weatherText)?.text = getString(R.string.temperature_as_celsius, forecast.temp.toInt())
        view?.findViewById<TextView>(R.id.rainText)?.text = getString(R.string.rain_probability, forecast.rain)
    }

    override fun handleError(error: AppError) {
        super.handleError(error)

        view?.findViewById<TextView>(R.id.weatherText)?.text = DEFAULT_ERROR_VALUE
        view?.findViewById<TextView>(R.id.rainText)?.text = DEFAULT_ERROR_VALUE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.weather_display, container, false)
        setupView(view)

        return view
    }

    companion object {
        private const val DEFAULT_ERROR_VALUE = "S/D"
    }
}