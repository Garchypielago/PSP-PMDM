package com.example.finalproject

import android.os.Bundle
import android.view.View
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

        with(binding) {
//            usersName.text = myMessage
            myNavigationView.getHeaderView(0).findViewById<TextView>(R.id.headerUsersName).text =
                "Welcome,\n" + myMessage + "!!"
//            para que busque ese elemnto me tengo que meter en el header por este trozo de xml:
//            app:headerLayout="@layout/header_menu"


//            Creacion del NavMenu
            setSupportActionBar(myToolbar)

//            Creacion del NavMenu
            val toggle = ActionBarDrawerToggle(
                this@MainActivity, main, myToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            main.addDrawerListener(toggle)
            toggle.syncState()


//            Seteo del NavMenu
            myNavigationView.setNavigationItemSelectedListener {

//                Esto lo he encontardo por internet para borrar el fragmento o los fragmentos que haya
                val myFragmentManager: FragmentManager = supportFragmentManager
                val fragments = myFragmentManager.fragments

                for (fragment in fragments) {
                    fragment?.let {
                        myFragmentManager.beginTransaction()
                            .remove(it)
                            .commit()
                    }
                }

                if (it.itemId == R.id.id_web) {
                    val myFragmentTransaction: FragmentTransaction =
                        myFragmentManager.beginTransaction()
//                    val myFragment: WebFragment = WebFragment.newInstance("http://10.0.2.2:8080/contextpath/")
//                    val myFragment: WebFragment = WebFragment.newInstance("http://192.168.1.189:8080/contextpath/")
//                    val myFragment: WebFragment = WebFragment.newInstance("http://192.168.1.46:8080/contextpath/")
                    val myFragment: WebFragment =
                        WebFragment.newInstance("http://10.227.189.204:8080/contextpath/")
                    layoutWelcome.visibility = View.GONE

                    myFragmentTransaction
                        .add(R.id.myLinearLayout, myFragment)
                        .commit()
                }

                if (it.itemId == R.id.id_products) {
                    val myFragmentTransaction: FragmentTransaction =
                        myFragmentManager.beginTransaction()
                    val myFragment: ProductsFragment = ProductsFragment.newInstance()

                    layoutWelcome.visibility = View.GONE

                    myFragmentTransaction
                        .add(R.id.myLinearLayout, myFragment)
                        .commit()
                }

                if (it.itemId == R.id.id_cart) {
                    val myFragmentTransaction: FragmentTransaction =
                        myFragmentManager.beginTransaction()
                    val myFragment: CartFragment = CartFragment.newInstance()
//                    val myFragment: ProductsFragment = ProductsFragment.newInstance()

                    layoutWelcome.visibility = View.GONE

                    myFragmentTransaction
                        .add(R.id.myLinearLayout, myFragment)
                        .commit()
                }

                true
            }


        }


    }

}