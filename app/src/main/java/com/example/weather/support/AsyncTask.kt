package com.example.weather.support

class AsyncTask {
    companion object {
        fun run(block: () -> Unit) {
            val thread = Thread {
                kotlin.run {block()}
            }

            thread.start()
        }
    }
}