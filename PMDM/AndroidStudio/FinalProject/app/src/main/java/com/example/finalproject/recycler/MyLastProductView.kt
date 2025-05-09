package com.example.finalproject.recycler;

import android.view.View;
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R

class MyLastProductView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val pokeShowed = itemView.findViewById<View>(R.id.pokeShowed) as TextView
    val btnShowMore = itemView.findViewById<Button>(R.id.btnShowMore) as Button

}
