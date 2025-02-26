package com.example.primeraspruebas

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener,
    AdapterView.OnItemSelectedListener {

    lateinit var miTextView: TextView
    lateinit var miBtn: ImageButton
    lateinit var miImageView: ImageView
    lateinit var miSpinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        miTextView = findViewById(R.id.txt1)
        miBtn = findViewById(R.id.btn1)
//        miImageView = findViewById(R.id.img1)
        miSpinner = findViewById(R.id.spinner1)


        miBtn.setOnClickListener(this)
        miBtn.setOnLongClickListener(this)

        miSpinner.setOnItemSelectedListener(this)

//        miBtn.setOnClickListener(View.OnClickListener {
//            miImageView.setImageResource(R.drawable.sigue_trabajando)
//        })


        val paises = arrayOf<String>("Italia", "Holanda", "Inglaterra")
        var miAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, paises)

        miAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        miSpinner.adapter = miAdapter

    }

    override fun onClick(v: View?) {
        miTextView.text = "Funciona"
        miTextView.setTextColor(Color.MAGENTA)
        miImageView.setImageResource(R.drawable.sigue_trabajando)
        Log.i("MiPrimeraApp", "Mi primer mensaje")
    }

    override fun onLongClick(v: View?): Boolean {
        miTextView.text = "Funciona Long"
        miTextView.setTextColor(Color.CYAN)
        return true
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        miTextView.text=miSpinner.selectedItem.toString();
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        miTextView.text="";
    }

}