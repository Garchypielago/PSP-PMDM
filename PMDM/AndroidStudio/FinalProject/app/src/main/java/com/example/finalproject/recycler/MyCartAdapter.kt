package com.example.finalproject.recycler

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.CartFragment
import com.example.finalproject.R
import com.example.finalproject.entities.CartPokemon
import com.example.finalproject.models.ResponseCart
import com.example.finalproject.viewModels.CartViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyCartAdapter(private val dataSet: ResponseCart, val myCartViewModel: CartViewModel) :
    RecyclerView.Adapter<MyCartView>() {

    private lateinit var myContext: Context

    var clickPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartView {
        myContext = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_cart, parent, false)
        return MyCartView(view)
    }

    override fun getItemCount() = dataSet.products.size

    override fun onBindViewHolder(holder: MyCartView, position: Int) {
        if (position == clickPosition) {
            holder.constCart.setBackgroundColor(Color.parseColor("#FCC201"))
        } else {
            holder.constCart.setBackgroundColor(Color.TRANSPARENT)
        }

        val product = dataSet.products[position]

        val url: String = product.url
        Glide.with(myContext)
            .load(url)
            .into(holder.cartImg)

        holder.cartName.text = product.pokemonName
        holder.cartQuantity.text = "x${product.productNumber}"
        holder.cartTotal.text = "${product.totalPrice}P¥"
        holder.cartPrice.text = "${product.unitPrice}P¥"

        holder.constCart.setOnClickListener {
            notifyItemChanged(clickPosition)
            clickPosition = position
            notifyItemChanged(clickPosition)
            alert(it, product, myCartViewModel)
        }
    }

    fun alert(v: View, pokemon: CartPokemon, myCartViewModel: CartViewModel) {
        var myAlert = AlertDialog.Builder(myContext)
        myAlert.setTitle("Delete item alert")
        myAlert.setMessage("Are you sure you want to delete ${pokemon.pokemonName}?")
        myAlert.setPositiveButton(
            "Yes, I am sure",
            DialogInterface.OnClickListener({ dialog, which ->
                notifyItemChanged(clickPosition)
                clickPosition = -1
                notifyItemChanged(clickPosition)
                myCartViewModel.deleteProductFromCart(pokemon.id.toLong())
            })
        )
        myAlert.setNegativeButton("Cancel") { dialog, which ->
            notifyItemChanged(clickPosition)
            clickPosition = -1
            notifyItemChanged(clickPosition)
        }
        val dialog = myAlert.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}