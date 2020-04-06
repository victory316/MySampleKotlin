package com.example.sampleappbyme.main.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sampleappbyme.R
import com.example.sampleappbyme.main.util.obtainViewModel
import com.example.sampleappbyme.main.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host)

        Handler().postDelayed({
            navController.navigate(R.id.action_go_to_main_fragment)
        }, 1200)

        Timber.d("onCreate on MainActivity")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Timber.d("configuration changed : $newConfig")

        super.onConfigurationChanged(newConfig)
    }

    fun setupForegroundService() {

        val builder = NotificationCompat.Builder(this, CHANNEL_ID).apply {
            setContentTitle("Picture Download")
            setContentText("Download in progress")
            setSmallIcon(R.drawable.ic_launcher_foreground)
            priority = NotificationCompat.PRIORITY_LOW
        }

        NotificationManagerCompat.from(this).apply {
            // Issue the initial notification with zero progress
            builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false)
            notify(NOTIFICATION_ID, builder.build())

            // Do the job here that tracks the progress.
            // Usually, this should be in a
            // worker thread
            // To show progress, update PROGRESS_CURRENT and update the notification with:
            // builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
            // notificationManager.notify(notificationId, builder.build());

            // When done, update the notification one more time to remove the progress bar
            builder.setContentText("Download complete")
                .setProgress(0, 0, false)
            notify(NOTIFICATION_ID, builder.build())
        }



    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host).navigateUp()

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)

    companion object {
        const val CHANNEL_ID = "TEMP_CHANNEL"
        const val NOTIFICATION_ID = 1

        const val PROGRESS_MAX = 100
        const val PROGRESS_CURRENT = 0
    }
}
