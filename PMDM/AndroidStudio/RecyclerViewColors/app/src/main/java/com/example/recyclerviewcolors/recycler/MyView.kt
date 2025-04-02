package com.example.recyclerviewcolors.recycler

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcolors.R

class MyView(itemView: View) : RecyclerView.ViewHolder(itemView){

    val tvColors : TextView = itemView.findViewById(R.id.textViewColor)
    val tvCode : TextView = itemView.findViewById(R.id.textViewCode)
    val rowColor : LinearLayout = itemView.findViewById(R.id.rowColor)


}