package com.example.broadcastreseiversms;

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.telephony.TelephonyManager

class ServicePhoneStateWithBroadcastReceiver : Service() {
    val br : MyBroadcastReceiver = MyBroadcastReceiver()
    val iFilter : IntentFilter = IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED)
    override fun onBind(intent: Intent?): IBinder? {
        //TODO("Not yet implemented")
        return null
    }

    override fun onCreate() {
        super.onCreate()

        registerReceiver(br, iFilter )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Aquí se realiza el código para el servicio
        return START_STICKY
    }

    override fun onDestroy() {
        // Aquí se realiza el código para detener el servicio
        super.onDestroy()
    }

}