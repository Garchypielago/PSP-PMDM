package com.example.finalproject.recycler

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R

class MyProductView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val productImg = itemView.findViewById<View>(R.id.pokeImg) as ImageView
    val productName = itemView.findViewById<View>(R.id.pokeName) as TextView
    val productPrice = itemView.findViewById<View>(R.id.pokePrice) as TextView
    val productDes = itemView.findViewById<View>(R.id.pokeDes) as TextView
    val productRegion = itemView.findViewById<View>(R.id.pokeRegion) as TextView
    val productId = itemView.findViewById<View>(R.id.pokeId) as TextView
    val productType01 = itemView.findViewById<View>(R.id.typeLogo1) as TextView
    val productType02 = itemView.findViewById<View>(R.id.typeLogo2) as TextView
    val productStock = itemView.findViewById<View>(R.id.pokeStock) as TextView
    val productLegendary = itemView.findViewById<View>(R.id.pokeLegendary) as ImageView
    val productBuyBtn = itemView.findViewById<Button>(R.id.pokeBuyBtn)

}