package com.example.threads_corutines

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.threads_corutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

//    con el binding nos ahorramos hacer los find, y crear elementos de lateinit, trbajamos con ids
    lateinit var binding: ActivityMainBinding
    private lateinit var coroutine: Job
    private lateinit var coroutine2: Job


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

        with(binding){
//        qui puedo llamar a los elementos sin el binding.blablabla
            btToast.setOnClickListener {showToast("Hello")}
            btSinHilos.setOnClickListener {
                pB1.max=100
                pB1.progress = 0
                for (i in 1..10){
//                  Suspend function 'longTask' should be called only from a coroutine or another suspend function
                    longTask()
                    pB1.progress += 10
                }
                showToast("Finish Task")
                myTV.text = "Finish Task"
            }

            btConHilos.setOnClickListener{
                btConHilos.isEnabled=false
                coroutine = lifecycleScope.launch {
                    coroutine2 = lifecycleScope.launch {
                        longTask3();
                        showToast("Tercer hilo acabado")
                    }

                    pB1.max=100
                    pB1.progress = 0
                    for (i in 1..10){
                        longTask2()
                        pB1.progress += 10
                    }
                    showToast("Finish Task")
                    myTV.text = "Finish Task"
                    btConHilos.isEnabled=true

                }
                myTV.text = "Coroutine in progress"
            }

            btStop.setOnClickListener{
                coroutine2.cancel()
                myTV.text="Task cancel"
            }

        }
    }


//    se lo he puesto en el onclick
    fun showToast(message : String){
        var myToast: Toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        myToast.show()
    }

    private fun longTask(){
//    suspend fun longTask(){
        Thread.sleep(1000)
//        delay(1000)
    }


    suspend fun longTask2() {
        delay(1000)
    }

    suspend fun longTask3() {
        delay(15000)
    }

}