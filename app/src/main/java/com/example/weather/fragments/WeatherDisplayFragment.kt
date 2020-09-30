package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.models.Forecast
import com.example.weather.viewmodels.ForecastViewModel

class WeatherDisplayFragment() : Fragment() {
    private lateinit var viewModel: ForecastViewModel

    private fun temperatureAsCelsiusStr(forecast: Forecast?): String {
        return "${forecast?.temperature?.toInt()} ºC"
    }

    private fun rainProbabilityStr(forecast: Forecast?): String {
        return "10% lluvia"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
        val forecast = viewModel.fetchForecast()

        val view = inflater.inflate(R.layout.weather_display, container, false)
        view.findViewById<TextView>(R.id.weatherText)?.text = temperatureAsCelsiusStr(forecast)
        view.findViewById<TextView>(R.id.rainText)?.text = rainProbabilityStr(forecast)

        return view
    }
}