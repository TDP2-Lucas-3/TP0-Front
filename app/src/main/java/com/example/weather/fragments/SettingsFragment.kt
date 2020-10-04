package com.example.weather.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.weather.R
import com.example.weather.WeatherDefaults.Companion.RAIN_THRESHOLD

class SettingsFragment : Fragment() {

    private fun openModal() {
        val input = EditText(activity)
        input.inputType = InputType.TYPE_CLASS_NUMBER
        val key = activity!!.getString(R.string.RAIN_PERCENTAGE_THRESHOLD)
        val preferences = activity!!.getSharedPreferences(
            key,
            Context.MODE_PRIVATE
        )
        val currentValue = preferences.getInt(key, RAIN_THRESHOLD)
        input.setText(currentValue.toString())
        AlertDialog.Builder(this.activity!!)
            .setTitle(getString(R.string.config))
            .setView(input)

            .setPositiveButton("Aceptar") { _: DialogInterface, _: Int ->
                val percentage = input.text.toString()
                with (preferences.edit()) {
                    putInt(key, percentage.toInt())
                    commit()
                }
            }

            .setNegativeButton("Cancelar") { dialog: DialogInterface?, _: Int ->
                dialog?.cancel()
            }
            .show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val createdView = inflater.inflate(R.layout.settings, container, false)
        val settingsButton = createdView?.findViewById<ImageButton>(R.id.settingsButton)
        settingsButton?.setOnClickListener {
            Log.i("WeatherSettings", "CLICKED")
            openModal()
        }
        return createdView
    }
}