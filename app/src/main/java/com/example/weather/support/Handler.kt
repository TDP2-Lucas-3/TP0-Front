package com.example.weather.support

import android.graphics.Color
import android.view.View
import com.example.weather.errors.AppError
import com.google.android.material.snackbar.Snackbar

class Handler {
    companion object {
        fun handleError(view: View, error: AppError) {
            val snackBar = Snackbar.make(view, error.getMessage(), Snackbar.LENGTH_LONG)
            snackBar.view.setBackgroundColor(Color.RED)
            snackBar.show()
        }
    }
}