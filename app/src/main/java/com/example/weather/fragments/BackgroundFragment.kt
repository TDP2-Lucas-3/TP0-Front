package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weather.R
import com.example.weather.models.Forecast

class BackgroundFragment : ForecastFragment() {
    override fun updateScreen(forecast: Forecast) {
        activity?.findViewById<ConstraintLayout>(R.id.container_layout)?.setBackgroundResource(R.drawable.rain)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.empty, container, false)
    }
}