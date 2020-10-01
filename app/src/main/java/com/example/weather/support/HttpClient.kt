package com.example.weather.support

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HttpClient {
    fun<T> getAPI(API: Class<T>): T {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api: T? = retrofit.create(API)

        if (api != null) {
            return api
        }
        throw Exception("Error instanciando API client")
    }

    companion object {
        private const val HOST = "https://tp0-lucas3.herokuapp.com/"
    }
}