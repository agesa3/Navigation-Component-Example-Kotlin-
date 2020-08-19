package com.agesa.navigationcomponent

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDeepLinkBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendFakeNotification()
    }
    private fun sendFakeNotification() {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel0", "name", importance)
            notificationManager.createNotificationChannel(channel)
        }

        val args = BoatFragmentArgs.Builder(3).build().toBundle()

        val pendingIntent = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.boatFragment)
            .setArguments(args)
            .createPendingIntent()

        val notification = Notification.Builder(this)
            .setContentTitle("Now on sale!")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.boat)
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.setChannelId("channel0")
        }

        notificationManager.notify(0, notification.build())
    }
}