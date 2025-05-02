package com.example.finalproject.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.models.ResponseCart

class MyCartAdapter(private val dataSet: ResponseCart): RecyclerView.Adapter<MyCartView>() {

    private lateinit var myContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartView {
        myContext = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_cart, parent, false)
        return MyCartView(view)
    }

    override fun getItemCount() = dataSet.products.size

    override fun onBindViewHolder(holder: MyCartView, position: Int) {
        val product = dataSet.products[position]
        Log.d("MyCartAdapter", "Product: $product")

        val url: String = product.url
        Glide.with(myContext)
            .load(url)
            .into(holder.cartImg)

        holder.cartName.text = product.pokemonName
        holder.cartQuantity.text = "x${product.productNumber}"
        holder.cartTotal.text = "${product.totalPrice}P¥"
        holder.cartPrice.text = "${product.unitPrice}P¥"

    }
}