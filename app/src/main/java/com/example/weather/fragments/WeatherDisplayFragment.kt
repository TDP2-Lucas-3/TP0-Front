package com.example.weather.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.models.Forecast
import com.example.weather.repositories.ForecastRepository
import com.example.weather.viewmodels.ForecastViewModel

class WeatherDisplayFragment() : Fragment() {
    private var forecast: Forecast? = null

    private fun temperatureAsCelsiusStr(): String {
        return "${forecast?.temp?.toInt()} ºC"
    }

    private fun rainProbabilityStr(): String {
        return "${forecast?.rain?.toInt()}% lluvia"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val thread = Thread {
            kotlin.run {
                forecast = ForecastRepository().fetchForecast()
                Log.i("Forecast", forecast!!.temp.toString())
                view?.findViewById<TextView>(R.id.weatherText)?.text =
                    temperatureAsCelsiusStr()
                view?.findViewById<TextView>(R.id.rainText)?.text = rainProbabilityStr()

            }
        }

        thread.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.weather_display, container, false)
        view.findViewById<TextView>(R.id.weatherText)?.text = temperatureAsCelsiusStr()
        view.findViewById<TextView>(R.id.rainText)?.text = rainProbabilityStr()

        return view
    }
}