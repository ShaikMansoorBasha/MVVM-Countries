package com.example.mvvm_countries.view

import android.os.*
import androidx.appcompat.app.*
import com.example.mvvm_countries.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("******onCreate()******")
    }
    override fun onStart() {
        super.onStart()
        println("******onStart()******")
    }

    override fun onResume() {
        super.onResume()
        println("******onResume()******")
    }

    override fun onPause() {
        super.onPause()
        println("******onPause()******")
    }
    override fun onStop() {
        super.onStop()
        println("******onStop()******")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("******onDestroy()******")
    }
    override fun onRestart() {
        super.onRestart()
        println("******onRestart()******")
    }
}