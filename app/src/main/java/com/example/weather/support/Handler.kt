package com.example.weather.support

import android.content.Context
import android.widget.Toast
import com.example.weather.errors.AppError

class Handler {
    companion object {
        fun handleError(context: Context, error: AppError) {
            Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show()
        }
    }
}