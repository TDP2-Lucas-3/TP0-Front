package com.example.weather.support

import okhttp3.OkHttpClient
import okhttp3.Request

class HttpClient {
    private val client = OkHttpClient()

    fun get(resource: String): String {
        val request = Request.Builder()
            .url("$HOST/$resource")
            .build()

        client.newCall(request).execute().use { response -> return response.body!!.string() }
    }

    companion object {
        private const val HOST = "https://tp0-lucas3.herokuapp.com/"
    }
}