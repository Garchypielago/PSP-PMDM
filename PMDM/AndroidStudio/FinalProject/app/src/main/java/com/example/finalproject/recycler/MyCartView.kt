package com.example.finalproject.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R

class MyCartView(itemView: View): RecyclerView.ViewHolder(itemView) {

    val cartImg = itemView.findViewById<View>(R.id.cartImg) as ImageView
    val cartName = itemView.findViewById<View>(R.id.cartName) as TextView
    val cartQuantity = itemView.findViewById<View>(R.id.cartQuantity) as TextView
    val cartTotal = itemView.findViewById<View>(R.id.cartTotal) as TextView
    val cartPrice = itemView.findViewById<View>(R.id.cartPrice) as TextView
    val constCart = itemView.findViewById<View>(R.id.constCart) as View
}