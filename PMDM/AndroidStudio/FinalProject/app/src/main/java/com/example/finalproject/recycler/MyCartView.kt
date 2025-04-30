package com.example.finalproject.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R

class MyCartView(itemView: View): RecyclerView.ViewHolder(itemView) {

    val productImg = itemView.findViewById<View>(R.id.cartImg) as ImageView
    val productName = itemView.findViewById<View>(R.id.cartName) as TextView
}