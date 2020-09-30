package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.weather.R
import com.example.weather.viewmodels.ForecastViewModel
import kotlinx.android.synthetic.main.activity_main.*

class WeatherDisplayFragment() : Fragment() {
    private lateinit var viewModel: ForecastViewModel;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
        val forecast = viewModel.fetchForecast()
        activity?.findViewById<TextView>(R.id.weatherText)?.text = forecast?.weather;
        return inflater.inflate(R.layout.weather_display, container, false)
    }
}