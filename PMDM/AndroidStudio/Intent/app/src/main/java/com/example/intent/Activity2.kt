package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myExtra: Bundle? = intent.extras
        var myMessage: String? = myExtra?.getString("Send")
        findViewById<TextView>(R.id.myTxtSend).text = myMessage

        findViewById<Button>(R.id.myBackBtn).setOnClickListener{
            val myResult = Intent()
            myResult.putExtra("Back", findViewById<EditText>(R.id.myBackTxt).text.toString())
            setResult(RESULT_OK, myResult)

            this.finish()
        }

    }
}