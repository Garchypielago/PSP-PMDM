package com.example.jugandoalosdados

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.jugandoalosdados.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.sql.Time

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapterEvenOdd: ArrayAdapter<String>
    lateinit var adapterLowerHigher: ArrayAdapter<String>
    lateinit var coroutine: Job
    var balance: Int = 100


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

        adapterEvenOdd = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.EvenOdd)
        )
        adapterLowerHigher = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.LowerHigher)
        )

        adapterEvenOdd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterLowerHigher.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

//        elements
        with(binding) {
            changeBalance(textViewMoney)

            toggleButton.isSingleSelection = true

            buttonEvenOdd.setOnClickListener {
                if (spinner.adapter != adapterEvenOdd)
                    spinner.adapter = adapterEvenOdd
                else
                    spinner.adapter = null;
            }
            buttonLowHigh.setOnClickListener {
                if (spinner.adapter != adapterLowerHigher)
                    spinner.adapter = adapterLowerHigher
                else
                    spinner.adapter = null;
            }

            buttonSubmit.setOnClickListener {
                textViewNum1.text = "-"
                textViewNum2.text = "-"

//                logica de errores
                if(throwSnackbar(binding))
                    return@setOnClickListener

                var bet = editTextNumber.text.toString().toInt()
                spinner.isEnabled = false
                buttonLowHigh.isEnabled = false
                buttonEvenOdd.isEnabled = false
                editTextNumber.isEnabled = false
                buttonSubmit.isEnabled = false
//                logica de dados
                var num1 : Int = (1..6).random()
                var num2 : Int = (1..6).random()
                var totalNum = num1 + num2


//                logica de eleccion
                var result:Boolean = when(spinner.selectedItem.toString()){
                    "Even" -> isEven(totalNum)
                    "Odd" -> !isEven(totalNum)
                    "Lower half" -> isLower(totalNum)
                    "Higher half" -> !isLower(totalNum)
                    else -> {false}
                }

//                logica del gif
                coroutine = lifecycleScope.launch {
                    Glide.with(applicationContext).load(R.drawable.dado_imagen_animada_0092).into(imageView);
                    delay(3000)

                    textViewNum1.text = num1.toString()
                    textViewNum2.text = num2.toString()

//                logica de ganar
                    if (result){
                        imageView.setImageResource(R.drawable.ganar_dados)
                        balance += bet
                    } else{
                        imageView.setImageResource(R.drawable.perder_dados)
                        balance -= bet
                    }
                    changeBalance(textViewMoney)

//                    logica de alertas
                    delay(1000)
                    if(balance == 0) {
                        finalAlert()
                        imageView.setImageResource(R.drawable.bancarrota)
                    }else {
                        alert()
                    }

                    spinner.isEnabled = true
                    buttonLowHigh.isEnabled = true
                    buttonEvenOdd.isEnabled = true
                    buttonSubmit.isEnabled = true
                    editTextNumber.isEnabled = true
                }

            }
        }
    }

    //    functions
    fun snackbar(myCoordinator: CoordinatorLayout, message: String) {
        var mySnackbar: Snackbar = Snackbar.make(myCoordinator, message, Snackbar.LENGTH_LONG)
        mySnackbar.setTextColor(Color.BLACK)
        mySnackbar.show()
    }

    fun alert(){
        var myAlert = AlertDialog.Builder(this)
        myAlert.setTitle("Rolling the dices")
        myAlert.setMessage("Do you want to continue?")
        myAlert.setPositiveButton("Continue", null)
        myAlert.setNegativeButton("Exit"){ _, _ ->
            this.finish();
        }
        myAlert.create().show()
    }

    fun finalAlert(){
        var myAlert = AlertDialog.Builder(this)
        myAlert.setTitle("Rolling the dices")
        myAlert.setMessage("You are broke. Please leave the game")
        myAlert.setNegativeButton("Exit"){ _, _ ->
            this.finish();
        }
        myAlert.create().show()
    }

    fun changeBalance(textView: TextView){
        textView.text = balance.toString();
    }

    fun throwSnackbar(binding: ActivityMainBinding): Boolean{
        with(binding){
            if (spinner.adapter == null) {
                snackbar(CoordinatorLayout, "Must choose a game mode")
                return true
            }
            if (editTextNumber.text.toString() == "") {
                snackbar(CoordinatorLayout, "Must choose money to bet")
                return true
            }
            if (editTextNumber.text.toString().toInt() <= 0) {
                snackbar(CoordinatorLayout, "Bet must to be higher than 0")
                return true
            }
            if (editTextNumber.text.toString().toDouble() > balance) {
                snackbar(CoordinatorLayout, "Bet must to be equals or lower than your balance")
                return true
            }
        }
        return  false
    }

    fun isEven(totalNum: Int) : Boolean{
        if(totalNum % 2 == 0 )
            return true
        return false
    }

    fun isLower(totalNum: Int) : Boolean {
        if(totalNum < 7 )
            return true
        return false
    }


}