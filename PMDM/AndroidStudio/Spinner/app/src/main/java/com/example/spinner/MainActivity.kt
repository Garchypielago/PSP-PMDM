package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinnerGeneric : Spinner
    lateinit var spinnerSpecific : Spinner
    lateinit var imageViewTheme : ImageView

    lateinit var adapterTVshows : ArrayAdapter<String>
    lateinit var adapterMusic : ArrayAdapter<String>
    lateinit var adapterAnime : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerGeneric = findViewById(R.id.spinnerGeneric)
        spinnerSpecific = findViewById(R.id.spinnerSpecific)
        imageViewTheme = findViewById(R.id.imageViewTheme)

        adapterTVshows = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.SpecificTVshowsThemes))
        adapterMusic = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.SpecificMusicThemes))
        adapterAnime = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.SpecificAnimeThemes))

        adapterTVshows.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterMusic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterAnime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGeneric.onItemSelectedListener = this
        spinnerSpecific.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(R.id.spinnerGeneric == parent?.id)
            changeSpecificSpinner(position);

        imageViewTheme.setImageResource(changeImage());
    }

    private fun changeSpecificSpinner(position: Int){
        if (position == 0)
            spinnerSpecific.adapter = adapterTVshows
        if (position == 1)
            spinnerSpecific.adapter = adapterMusic
        if (position == 2)
            spinnerSpecific.adapter = adapterAnime
    }

    private fun changeImage(): Int {
        var image = when(spinnerSpecific.selectedItem.toString()){
            "Friends" -> R.drawable.friends
            "How I met your mother" -> R.drawable.howimetyourmother
            "The Big Bang theory" -> R.drawable.thebigbangtheory
            "IZAL" -> R.drawable.izal
            "Maná" -> R.drawable.mana
            "Ciudad Jara" -> R.drawable.ciudadjara
            "One Piece" -> R.drawable.onepiece
            "Solo Leveling" -> R.drawable.sololeveling
            "Sousou no Frieren" -> R.drawable.sousounofrieren
            else -> 0
        }
        return image
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


}