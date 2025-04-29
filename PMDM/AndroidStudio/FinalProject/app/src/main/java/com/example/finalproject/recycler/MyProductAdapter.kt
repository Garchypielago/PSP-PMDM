package com.example.finalproject.recycler

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.entities.Pokemon
import com.example.finalproject.enums.Regions
import com.example.finalproject.enums.Types
import com.example.finalproject.models.ResponseShopedex

class MyProductAdapter(
    private val dataSet: ResponseShopedex,
    private val onProductClick: (product: Pokemon) -> Unit  // sol internet
) : RecyclerView.Adapter<MyProductView>() {

    private lateinit var myContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductView {
        myContext = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_products, parent, false)
        return MyProductView(view)
    }

    override fun getItemCount() = dataSet.content.size

    override fun onBindViewHolder(holder: MyProductView, position: Int) {
        val product = dataSet.content[position]

        // Configuración de la vista con los datos del producto
        val url: String = product.url
        Glide.with(myContext)
            .load(url)
            .into(holder.productImg)

        holder.productName.text = product.name
        holder.productPrice.text = "${product.price}P¥"
        holder.productDes.text = product.description
        holder.productRegion.text = Regions.entries[product.region - 1].toString()
        holder.productId.text = "Nº${product.id.toString().padStart(4, '0')}"
        holder.productStock.text = product.stock.toString()

        if (product.legendary) {
            Glide.with(myContext)
                .load(R.drawable.masterball)
                .into(holder.productLegendary)
        }

        val type1 = Types.entries[product.type1 - 1].toString()
        val type2 = product.type2

        if (type2 != null) {
            holder.productType01.text = type1
            holder.productType01.setBackgroundTintList(ColorStateList.valueOf(backgroundType(type1)))
            holder.productType02.text = Types.entries[type2 - 1].toString()
            holder.productType02.setBackgroundTintList(ColorStateList.valueOf(backgroundType(Types.entries[type2 - 1].toString())))
        } else {
            holder.productType02.text = type1
            holder.productType02.setBackgroundTintList(ColorStateList.valueOf(backgroundType(type1)))
            holder.productType01.visibility = View.GONE
        }

//        solucion de internet
        holder.productBuyBtn.setOnClickListener {
            onProductClick(product)  // Notificamos al Fragment sobre el producto clickeado
        }
    }

    private fun backgroundType(type: String): Int{
        val typeStr = type.lowercase()

        when (typeStr) {
            "normal"   -> return Color.parseColor("#AABB99")
            "fire"     -> return Color.parseColor("#FF4422")
            "water"    -> return Color.parseColor("#3399FF")
            "electric" -> return Color.parseColor("#FFCC33")
            "grass"    -> return Color.parseColor("#77CC55")
            "ice"      -> return Color.parseColor("#66CCFF")
            "fighting" -> return Color.parseColor("#BB5544")
            "poison"   -> return Color.parseColor("#AA5599")
            "ground"   -> return Color.parseColor("#DDBB55")
            "flying"   -> return Color.parseColor("#8899FF")
            "psychic"  -> return Color.parseColor("#FF5599")
            "bug"      -> return Color.parseColor("#AABB22")
            "rock"     -> return Color.parseColor("#BBAA66")
            "ghost"    -> return Color.parseColor("#6666BB")
            "dragon"   -> return Color.parseColor("#7766EE")
            "dark"     -> return Color.parseColor("#775544")
            "steel"    -> return Color.parseColor("#AABBCC")
            "fairy"    -> return Color.parseColor("#EE99EE")
            else       -> return Color.TRANSPARENT
        }
    }
}