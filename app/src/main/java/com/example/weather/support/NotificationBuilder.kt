package com.example.weather.support

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.weather.R
import java.lang.Exception

class NotificationBuilder(private val context: Context, private val channel_id: String) {
    fun build(intent: Intent): Notification {
        createNotificationChannel()

        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val builder = NotificationCompat.Builder(context, "cloud")
            .setSmallIcon(R.drawable.ic_cloud_24px)
            .setContentTitle("Weather App")
            .setContentText("¡Si vas a salir no te olvides el paraguas!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setChannelId(channel_id)

        return builder.build() ?: throw Exception("Fatal error building notification")
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.weather_channel_name)
            val descriptionText = context.getString(R.string.weather_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channel_id, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}