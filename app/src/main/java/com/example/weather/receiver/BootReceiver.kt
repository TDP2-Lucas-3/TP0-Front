package com.example.weather.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_BOOT_COMPLETED
import com.example.weather.support.RainCheckAlarmSetup

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) {
            return
        }

        if (intent.action != ACTION_BOOT_COMPLETED) {
            return
        }

        RainCheckAlarmSetup().setup(context)
    }
}