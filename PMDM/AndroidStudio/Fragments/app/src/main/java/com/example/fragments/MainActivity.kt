package com.example.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    lateinit var imageViewMorfeo: ImageView
    lateinit var textViewUnderMorfeo: TextView
    lateinit var materialToolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Lo primero que hicimos
//        val btnShow = findViewById<Button>(R.id.btnShow)
//        btnShow.setOnClickListener{
//            val textToSend = findViewById<TextView>(R.id.textToSend)
//            val myFragmentManager: FragmentManager = supportFragmentManager
//            val myFragmentTransaction: FragmentTransaction = myFragmentManager.beginTransaction()
//            val myFragment: FirstFragment = FirstFragment.newInstance(textToSend.text.toString())
//
//            myFragmentTransaction
//                .add(R.id.firstFragment, myFragment)
//                .commit()
//        }

        imageViewMorfeo = findViewById(R.id.imageView)
        textViewUnderMorfeo = findViewById(R.id.tV2)
        materialToolbar = findViewById(R.id.materialToolbar)

        setSupportActionBar(materialToolbar)
        supportActionBar?.hide()
        imageViewMorfeo.setOnClickListener{
            supportActionBar?.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.first_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.bluePill){
            textViewUnderMorfeo.setText("Olvidas Matrix y vives en paz")
            textViewUnderMorfeo.setTextColor(Color.BLUE)
        }
        if(item.itemId == R.id.redPill){
            textViewUnderMorfeo.setText("Abres la mente y decubres un nuevo todo")
            textViewUnderMorfeo.setTextColor(Color.RED)
        }
        if(item.itemId == R.id.exit){
            this.finish()
        }

        return super.onOptionsItemSelected(item)
    }
}