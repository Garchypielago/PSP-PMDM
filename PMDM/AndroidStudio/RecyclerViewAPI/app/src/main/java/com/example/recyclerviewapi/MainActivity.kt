package com.example.recyclerviewapi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapi.databinding.ActivityMainBinding
import com.example.recyclerviewapi.recycler.MyAdapter
import com.example.recyclerviewapi.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myViewModel: MainViewModel by viewModels()
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            val myLayout = LinearLayoutManager(this@MainActivity)
            rvPerros.layoutManager = myLayout

            bt2.setOnClickListener{
                val breed = edt2.getText().toString()
                if(breed.isEmpty()){
                    Toast.makeText(applicationContext, "Must choose a breed", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                myViewModel.returnPhotos(breed)
            }

            myViewModel.data.observe(this@MainActivity){
                if(it.status=="success"){
                    myAdapter = MyAdapter (it)
                    rvPerros.adapter = myAdapter
                } else {
                    Toast.makeText(applicationContext,"Don´t find any photos of this dog", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }

    }
}