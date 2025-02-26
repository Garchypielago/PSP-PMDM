package com.example.messages

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var myCoordinator : CoordinatorLayout
    lateinit var myView: View
    lateinit var myImageView: ImageView
    lateinit var myAnimation : AnimationDrawable
    lateinit var myBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView = findViewById(R.id.textExample);
        myCoordinator = findViewById(R.id.coordinatorExample);
        myImageView = findViewById(R.id.imageViewExample);
//        Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);
//        Glide.with(this).load(R.drawable.dado_imagen_animada_0092).into(myImageView);

        myImageView.setBackgroundResource(R.drawable.tragaperras);
        myAnimation = myImageView.background as AnimationDrawable

        myBtn = findViewById(R.id.buttonClose)
        myBtn.setOnClickListener({
            myAnimation.stop()
        })

    }


    fun toast(v: View){
        var myToast: Toast = Toast.makeText(this, "I am the Toast", Toast.LENGTH_LONG)
        myToast.show()
        myAnimation.start()
    }

    fun snackbar(v: View){
        var mySnackbar: Snackbar = Snackbar.make(myCoordinator, "I am the Snackbar", Snackbar.LENGTH_LONG)
        mySnackbar.setAction("mySnackBarAction", View.OnClickListener {
            textView.text = "Well done chaval"
        })
        mySnackbar.setTextColor(Color.BLACK)

        mySnackbar.show()
    }

    fun alert(v: View){
        var myAlert = AlertDialog.Builder(this)
        myAlert.setTitle("Alert")
        myAlert.setMessage("I am the Alert")
        myAlert.setPositiveButton("Ok", DialogInterface.OnClickListener({ dialog, which ->
            textView.text = "You press Ok";
        }))
        myAlert.setNegativeButton("Cancel"){ dialog, which ->
            this.finish();
        }
        myAlert.setNeutralButton("This is an amazing large button"){ _, _ ->
            textView.text = "You press Large";
        }
        myAlert.create().show()
    }

        fun customAlert(v: View){
            var myCustomAlert = AlertDialog.Builder(this)
            myCustomAlert.setTitle("Alert")
//            myCustomAlert.setMessage("I am the Alert")
            myView = layoutInflater.inflate(R.layout.loggin, null)
            myCustomAlert.setView(myView)
            myCustomAlert.setPositiveButton("Login", DialogInterface.OnClickListener({ dialog, which ->
                textView.text = "Bienvenido " + myView.findViewById<EditText>(R.id.username).text
            }))
            myCustomAlert.setNegativeButton("Cancel", null)
            myCustomAlert.setNeutralButton("Register"){ _, _ ->
                textView.text = "We can´t register more users today, srry";
            }
            myCustomAlert.create().show()
        }



}