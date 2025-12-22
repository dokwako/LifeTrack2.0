package org.lifetrack.ltapp.core.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

object DroidNotification {

    fun createNotificationChannel(context: Context) {
        val name = "Medication Reminders"
        val descriptionText = "Notifications for scheduled doses"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("MED_REMINDER_CH", name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}