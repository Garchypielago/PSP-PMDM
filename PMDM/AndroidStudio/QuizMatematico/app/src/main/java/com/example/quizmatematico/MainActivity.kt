package com.example.quizmatematico

import android.R.color
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {

    lateinit var constraintLayout : ConstraintLayout
//    lateinit var colorBackground : Drawable

    lateinit var switchChangeBackground : Switch

    lateinit var buttonRandomNumber : Button
    lateinit var textViewRandomNumber: TextView

    lateinit var radioGroupOptions: RadioGroup
    lateinit var buttonChecked : Button
    lateinit var textViewResult: TextView

    var year: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        constraintLayout = findViewById(R.id.main)

        switchChangeBackground = findViewById(R.id.switchChangeBackground)
//        colorBackground = constraintLayout.getBackground()

        buttonRandomNumber = findViewById(R.id.buttonRandomNumber)
        textViewRandomNumber = findViewById(R.id.textViewRandomNumber)

        radioGroupOptions = findViewById(R.id.radioGroupOptions)
        buttonChecked = findViewById(R.id.buttonChecked)
        buttonChecked.isEnabled=false;
        textViewResult = findViewById(R.id.textViewResult)

        radioGroupOptions.setOnCheckedChangeListener(this)
        buttonRandomNumber.setOnClickListener(this)
        buttonChecked.setOnClickListener(this)
        switchChangeBackground.setOnCheckedChangeListener(this)


    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.radioButtonYes, R.id.radioButtonNo -> {buttonChecked.isEnabled=true}
            else -> {buttonChecked.isEnabled=false}
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonRandomNumber -> randomNumber()
            R.id.buttonChecked -> checkLeapYear()
        }

    }

    private fun checkLeapYear() {
        var selection: Boolean?
        var leap: Boolean?

        Log.i("Entra","Entra en funcion")

        when (radioGroupOptions.getCheckedRadioButtonId()) {
            R.id.radioButtonYes -> {selection=true
                Log.i("Selectcion","Si")}
            R.id.radioButtonNo -> {selection=false
                Log.i("Selectcion","No")}
            else -> {
                textViewResult.text = "Error."
                Log.i("Selectcion","Error")
                return }
        }

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            leap = true
        } else {
            leap = false
        }

        if (selection==leap){
            textViewResult.text = "Wow, you win!"
            textViewResult.setTextColor(Color.GREEN)
            Log.i("final","Wow, you win!")
            return
        }

        textViewResult.text = "Nice try!"
        textViewResult.setTextColor(Color.RED)
        Log.i("final","Nice try!")
        return

    }

    private fun randomNumber() {
        year = (1900..2500).random()
        textViewRandomNumber.text = year.toString()
        radioGroupOptions.clearCheck()
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {
            constraintLayout.setBackgroundColor(Color.YELLOW);
        } else {
//            constraintLayout.setBackgroundColor((colorBackground as ColorDrawable).color);
            constraintLayout.setBackgroundColor(Color.BLACK);
        }
    }


}