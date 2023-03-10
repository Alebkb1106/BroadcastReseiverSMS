package com.example.broadcastreseiversms

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var targetNumber: EditText
    private lateinit var autoResponse: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        targetNumber = findViewById(R.id.editTextPhone)
        autoResponse = findViewById(R.id.editTextMessage)

        val saveConfigButton = findViewById<Button>(R.id.buttonSave)
        saveConfigButton.setOnClickListener {
            // Obtener el número de teléfono y el mensaje de respuesta automáticos ingresados por el usuario
            // Guardarlos en las preferencias compartidas usando la clase SharedPreferences
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("targetNumber", targetNumber.text.toString())
            editor.putString("responseMessage", autoResponse.text.toString())
            editor.apply()
            Toast.makeText(this, "¡La configuracion se ha guardado!", Toast.LENGTH_SHORT).show();
        }

        val startServiceButton = findViewById<Button>(R.id.buttonStart)
        startServiceButton.setOnClickListener {
            // Iniciar el servicio MyService usando la función startService()
            val intent = Intent(this, ServicePhoneStateWithBroadcastReceiver::class.java)
            startService(intent)
            Toast.makeText(this, "¡El servicio se ha iniciado!", Toast.LENGTH_SHORT).show();
        }

        val stopServiceButton = findViewById<Button>(R.id.buttonStop)
        stopServiceButton.setOnClickListener {
            // Detener el servicio MyService usando la función stopService()
            val intent = Intent(this, ServicePhoneStateWithBroadcastReceiver::class.java)
            stopService(intent)
            Toast.makeText(this, "¡El servicio se ha detenido!", Toast.LENGTH_SHORT).show();
        }

}}