package com.example.sampleappbyme.main.util

import android.R
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.annotation.Nullable
import androidx.core.app.NotificationCompat
import com.example.sampleappbyme.main.view.MainActivity


/**
 *
 *  Reference : http://snowdeer.github.io/android/2018/08/02/android-foreground-service-after-oreo/
 */
class HelloIntentService : Service() {

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        startForegroundService()
    }

    fun startForegroundService() {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val remoteViews = RemoteViews(packageName, R.layout.activity_list_item)
        val builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= 26) {
            val CHANNEL_ID = "snwodeer_service_channel"
            val channel = NotificationChannel(
                CHANNEL_ID,
                "SnowDeer Service Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .createNotificationChannel(channel)
            builder = NotificationCompat.Builder(this, CHANNEL_ID)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        builder.setSmallIcon(R.mipmap.sym_def_app_icon)
            .setContent(remoteViews)
            .setContentTitle("NEW NOTIFICATION")
        startForeground(1, builder.build())
    }
}