package com.example.lifecycle

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifecycle.databinding.ActivityMainBinding
import com.example.lifecycle.model.Datos
import com.example.lifecycle.viewModel.MainViewModel
import com.example.lifecycle.viewModel.MainViewModelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var numClicks = 0

//    Sin Flow
//    private val myViewModel: MainViewModel by viewModels()

//    Con Flow
    private val myViewModel: MainViewModelFlow by viewModels()

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

//        binding.textViewResult.text = "0"
//        binding.buttonAdd.setOnClickListener({
//            binding.textViewResult.text = (binding.textViewResult.text.toString().toInt() + binding.editTextNumber01.text.toString().toInt()).toString()
//            numClicks++
//            if(numClicks==5){
//                Toast.makeText(this,"5 clicks", Toast.LENGTH_LONG).show()
//            }
//        })
//
//        binding.buttonSubs.setOnClickListener({
//            binding.textViewResult.text = (binding.textViewResult.text.toString().toInt() - binding.editTextNumber01.text.toString().toInt()).toString()
//            numClicks++
//            if(numClicks==5){
//                Toast.makeText(this,"5 clicks", Toast.LENGTH_LONG).show()
//            }
//        })

        with(binding){

////            Sin Flow
//            myViewModel.datos.observe(this@MainActivity){
//                textViewResult.text = it.contador.toString()
//                numClicks = it.numClicks
//                if(it.showMessage){
//                    Toast.makeText(this@MainActivity, "Five clicks", Toast.LENGTH_LONG).show()
//                }
//            }

            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED){
                    myViewModel.datos.collect{
                        textViewResult.text = it.contador.toString()
                        numClicks=it.numClicks
                        if(it.showMessage){
                            Toast.makeText(this@MainActivity, "Five clicks", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }


            buttonAdd.setOnClickListener{
                myViewModel.add(editTextNumber01.text.toString().toInt(),
                    Datos(textViewResult.text.toString().toInt(),
                        numClicks,
                        false))
            }

//            buttonSubs.setOnClickListener{
//                myViewModel.sub(editTextNumber01.text.toString().toInt(),
//                    Datos(textViewResult.text.toString().toInt(),
//                        numClicks,
//                        false))
//            }
        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("contador", binding.textViewResult.text.toString())
//        outState.putInt("numClicks", numClicks)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        numClicks = savedInstanceState.getInt("numClicks")
//        binding.textViewResult.text = savedInstanceState.getString("contador")
//    }

}