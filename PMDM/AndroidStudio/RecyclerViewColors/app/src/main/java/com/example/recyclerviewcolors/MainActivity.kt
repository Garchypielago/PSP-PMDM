package com.example.recyclerviewcolors

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcolors.databinding.ActivityMainBinding
import com.example.recyclerviewcolors.model.MainViewModel
import com.example.recyclerviewcolors.recycler.MyAdapter

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
            myViewModel.returnList();
            val myLayout = LinearLayoutManager(this@MainActivity)
            rvColors.layoutManager = myLayout

            myViewModel.data.observe(this@MainActivity){
                myAdapter = MyAdapter (it)
                rvColors.adapter = myAdapter

                val myDividerItemDecoration =
                    DividerItemDecoration(
                        rvColors.getContext(),
                        myLayout.orientation
                    )
                rvColors.addItemDecoration(myDividerItemDecoration)
            }

            buttonDelete.setOnClickListener{
                if(myAdapter.clickPosition < 0){
                    Toast.makeText(applicationContext,"Must select a color", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                myViewModel.delete(myAdapter.clickPosition)
            }

            myViewModel.delete.observe(this@MainActivity){
                myAdapter.notifyItemRemoved(it.position)
                myAdapter.clickPosition = RecyclerView.NO_POSITION
                myAdapter.notifyItemRangeChanged(0, it.colors.size)
                rvColors.scheduleLayoutAnimation()
            }

            buttonAdd.setOnClickListener{
                var position = myAdapter.clickPosition+1
                myViewModel.add(position, editTextAdd.text.toString(), editTextAdd2.text.toString())
            }

            myViewModel.add.observe(this@MainActivity){
                myAdapter.notifyItemInserted(it.position)
                myAdapter.notifyItemRangeChanged(0, it.colors.size)
            }


        }
    }
}