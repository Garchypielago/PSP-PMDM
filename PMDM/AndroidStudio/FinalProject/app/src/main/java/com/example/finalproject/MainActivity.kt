package com.example.finalproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_login)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

// Intents paso de variables entre actividades
        val myExtra: Bundle? = intent.extras
        val myMessage: String? = myExtra?.getString("UserName")

        with(binding){
//            usersName.text = myMessage
            myNavigationView.getHeaderView(0).findViewById<TextView>(R.id.usersName).text = "Welcome,\n"+myMessage+"!!"
//            para que busque ese elemnto me tengo que meter en el header por este trozo de xml:
//            app:headerLayout="@layout/header_menu"


//            Creacion del NavMenu
            setSupportActionBar(myToolbar)

//            Creacion del NavMenu
            val toggle = ActionBarDrawerToggle(this@MainActivity, main, myToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
            main.addDrawerListener(toggle)
            toggle.syncState()



//            Seteo del Navenu
            myNavigationView.setNavigationItemSelectedListener {
                if(it.itemId == R.id.id_web){
                    val myFragmentManager: FragmentManager = supportFragmentManager
                    val myFragmentTransaction: FragmentTransaction = myFragmentManager.beginTransaction()
                    val myFragment: WebFragment = WebFragment.newInstance("http://10.0.2.2:8080/contextpath/")

                    myFragmentTransaction
                        .add(R.id.myLinearLayout, myFragment)
                        .commit()
                }
                true
            }

        }

    }

}