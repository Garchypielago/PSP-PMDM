package com.example.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var myActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.mySendBtn).setOnClickListener{
            var myIntent: Intent = Intent(this, Activity2 :: class.java)

            myIntent.putExtra("Send", findViewById<EditText>(R.id.mySendTxt).text.toString())

            startActivity(myIntent)
            myActivityResultLauncher.launch(myIntent)
        }

        myActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult? ->
                if (result!!.resultCode == Activity.RESULT_OK){
//                    acciones si va bn
                    val myIntentResult = result.data
                    findViewById<TextView>(R.id.myTxtBack).text = myIntentResult!!.extras!!.getString("Back")
                }else{
//                    acciones si no va bn
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
        }

    }
}