package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val TAG = "MyFirebaseMessagingService"

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived: $remoteMessage")
        remoteMessage?.data?.let {
            Log.d(TAG, "onMessageReceived: " + remoteMessage.data)
        }
        // TODO: Step 3.6 check messages for notification and call sendNotification
        // Check if message contains a notification payload.
        remoteMessage?.notification?.let {
            sendNotification(it.body!!)
        }

    }

    private fun sendNotification(body: String) {
        val notificationManager = ContextCompat.getSystemService(
            applicationContext,
            NotificationManager::class.java
        )
        notificationManager?.sendNotification(body,applicationContext)
    }

    override fun onNewToken(token: String?) {
        Log.d(TAG, "onNewToken: $token")
    }
}