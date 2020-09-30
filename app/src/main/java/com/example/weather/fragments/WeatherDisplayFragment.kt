package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.viewmodels.ForecastViewModel

class WeatherDisplayFragment() : Fragment() {
    private lateinit var viewModel: ForecastViewModel;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
        val forecast = viewModel.fetchForecast()

        val view = inflater.inflate(R.layout.weather_display, container, false)
        view.findViewById<TextView>(R.id.weatherText)?.text = forecast?.temperatureAsCelsiusStr()

        return view
    }
}