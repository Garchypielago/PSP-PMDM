package com.example.navmenu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    lateinit var myToolbar: MaterialToolbar
    lateinit var myMain: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myToolbar = findViewById(R.id.myToolbar)
        myMain = findViewById(R.id.main)

        setSupportActionBar(myToolbar)
//        supportActionBar?.show()

        val toggle = ActionBarDrawerToggle(this, myMain, myToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        myMain.addDrawerListener(toggle)
        toggle.syncState()

    }
}