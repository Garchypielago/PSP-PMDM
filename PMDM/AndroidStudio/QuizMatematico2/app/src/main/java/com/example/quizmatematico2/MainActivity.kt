package com.example.quizmatematico2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var buttonRandomNumber : Button
    lateinit var textViewRandomNumber: TextView

    lateinit var checkBoxOption1: CheckBox
    lateinit var checkBoxOption2: CheckBox
    lateinit var checkBoxOption3: CheckBox
    lateinit var checkBoxOption4: CheckBox
    lateinit var checkBoxOption5: CheckBox

    lateinit var buttonChecked : Button
    lateinit var textViewResult: TextView
    lateinit var imageViewResult: ImageView

    var randomNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonRandomNumber = findViewById(R.id.buttonRandomNumber)
        textViewRandomNumber = findViewById(R.id.textViewRandomNumber)

        checkBoxOption1 = findViewById(R.id.checkBoxOption1)
        checkBoxOption2 = findViewById(R.id.checkBoxOption2)
        checkBoxOption3 = findViewById(R.id.checkBoxOption3)
        checkBoxOption4 = findViewById(R.id.checkBoxOption4)
        checkBoxOption5 = findViewById(R.id.checkBoxOption5)


        buttonChecked = findViewById(R.id.buttonChecked)
        buttonChecked.isEnabled = false;
        textViewResult = findViewById(R.id.textViewResult)
        imageViewResult = findViewById(R.id.imageViewResult)

        buttonRandomNumber.setOnClickListener(this)
        buttonChecked.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonRandomNumber -> randomNumber()
            R.id.buttonChecked -> checkSomeSelected()
        }
    }

    private fun checkDivisible(): Boolean {
        if ((randomNum%2!=0 && checkBoxOption1.isChecked) || (randomNum%2==0 && !checkBoxOption1.isChecked)){
            return false
        }
        if ((randomNum%3!=0 && checkBoxOption2.isChecked) || (randomNum%3==0 && !checkBoxOption2.isChecked)){
            return false
        }
        if ((randomNum%5!=0 && checkBoxOption3.isChecked) || (randomNum%5==0 && !checkBoxOption3.isChecked)){
            return false
        }
        if ((randomNum%10!=0 && checkBoxOption4.isChecked) || (randomNum%10==0 && !checkBoxOption4.isChecked)){
            return false
        }

        return true
    }

    private fun checkSomeSelected(){
        if (checkBoxOption1.isChecked || checkBoxOption2.isChecked || checkBoxOption3.isChecked || checkBoxOption4.isChecked || checkBoxOption5.isChecked){
            checkResults(checkDivisible());
            return;
        }
        textViewResult.text = "You need to choose almost one option"
        textViewResult.setTextColor(Color.MAGENTA)

    }

    private fun checkResults( answer : Boolean){
        if (answer){
            textViewResult.text = "Wow, you win!"
            textViewResult.setTextColor(Color.GREEN)
            imageViewResult.setImageResource(R.drawable.ok)
        } else {
            textViewResult.text = "Oh, you lose..."
            textViewResult.setTextColor(Color.RED)
            imageViewResult.setImageResource(R.drawable.ko)
        }
    }

    private fun randomNumber() {
        randomNum = (1000..2000).random()
        textViewRandomNumber.text = "By what numbers is " + randomNum.toString() + " divisible?"
        buttonChecked.isEnabled = true;
        imageViewResult.setImageResource(0)
        textViewResult.text = "-"
        checkBoxOption1.isChecked = false
        checkBoxOption2.isChecked = false
        checkBoxOption3.isChecked = false
        checkBoxOption4.isChecked = false
        checkBoxOption5.isChecked = false
    }
}