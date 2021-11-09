package com.example.chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer
import android.os.SystemClock
import android.util.Log

import android.widget.Chronometer.OnChronometerTickListener



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val chronometer = findViewById<Chronometer>(R.id.chronometer)
        chronometer.onChronometerTickListener =
            OnChronometerTickListener { cArg ->
                val text = chronometer.text
                if (text.length == 5) {
                    chronometer.text = "00:$text"
                } else if (text.length == 7) {
                    chronometer.text = "0$text"
                }
                Log.d("layon.f", chronometer.base.toString())
            }
        val timeInMilSeconds = 3600000
        chronometer.base = SystemClock.elapsedRealtime() - timeInMilSeconds
        chronometer.start()
    }

}