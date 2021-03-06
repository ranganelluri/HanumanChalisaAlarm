package com.pulsehrm.hanumanchalisaalarm

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver :BroadcastReceiver() {

     override fun onReceive(context: Context?, intent: Intent?) {
        (context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(
                intent!!.getIntExtra("notificationId", 0),
                Notification.Builder(context).apply {
                    setSmallIcon(android.R.drawable.ic_dialog_info)

                    val i = Intent(context,videoActivity::class.java)

                    context.startActivity(i)

                    setContentTitle("Alarm Notification")
                    setSmallIcon(R.mipmap.ic_launcher_hanuman)
                    setContentText(intent.getCharSequenceExtra("reminder"))
                    setWhen(System.currentTimeMillis())
                    setAutoCancel(true)
                    setContentIntent(PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0))
                }.build()
        )
    }
}