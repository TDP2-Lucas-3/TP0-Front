package com.example.weather.errors

import com.example.weather.errors.AppError

class NetworkError : AppError {
    override fun getMessage(): String {
        return "No fue posible conectarse al servidor, por favor reintente más tarde"
    }
}