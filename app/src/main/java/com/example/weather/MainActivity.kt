package com.example.weather


import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.support.RainCheckAlarmSetup


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RainCheckAlarmSetup().setup(this)
        setContentView(R.layout.activity_main)


    }



}