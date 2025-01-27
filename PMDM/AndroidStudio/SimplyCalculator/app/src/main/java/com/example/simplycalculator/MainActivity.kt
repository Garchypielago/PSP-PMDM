package com.example.simplycalculator

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var TVresul: TextView
    lateinit var TVnum01: EditText
    lateinit var TVnum02: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        TVresul = findViewById(R.id.TVresulPrint)
        TVnum01 = findViewById(R.id.TextNumber01)
        TVnum02 = findViewById(R.id.TextNumber02)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

//    fun operation(v: View, ope: String){}
    fun suma(v: View){
        TVresul.text= (TVnum01.text.toString().toDouble() + TVnum02.text.toString().toDouble()).toString()
    }
    fun resta(v: View){
        TVresul.text= (TVnum01.text.toString().toDouble() - TVnum02.text.toString().toDouble()).toString()
    }
    fun multi(v: View){
        TVresul.text= (TVnum01.text.toString().toDouble() * TVnum02.text.toString().toDouble()).toString()
    }
    fun divi(v: View){
        TVresul.text= (TVnum01.text.toString().toDouble() / TVnum02.text.toString().toDouble()).toString()
    }

}