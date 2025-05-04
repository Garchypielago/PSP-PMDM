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
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {  // Cambiado: RecyclerView.ViewHolder para soportar múltiples tipos de vista

    private lateinit var myContext: Context

    // Definimos dos tipos de vista: producto y footer
    private val TYPE_PRODUCT = 0
    private val TYPE_FOOTER = 1

    override fun getItemCount(): Int {
        val hasMorePages = dataSet.pageable.pageNumber < dataSet.totalPages - 1
        return dataSet.content.size + if (hasMorePages) 1 else 0
    }

    override fun getItemViewType(position: Int): Int {
        val hasMorePages = dataSet.pageable.pageNumber < dataSet.totalPages - 1
        return if (hasMorePages && position == dataSet.content.size) TYPE_FOOTER else TYPE_PRODUCT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        myContext = parent.context
        return if (viewType == TYPE_PRODUCT) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_products, parent, false)
            MyProductView(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_products_add, parent, false)
            MyLastProductView(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyProductView) {
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

            // solucion de internet
            holder.productBuyBtn.setOnClickListener {
                onProductClick(product)  // Notificamos al Fragment sobre el producto clickeado
            }
        }

        if (holder is MyLastProductView) {
            holder.pokeShowed.text = "Page ${dataSet.pageable.pageNumber + 1} of ${dataSet.totalPages}."
        }
    }

    private fun backgroundType(type: String): Int {
        val typeStr = type.lowercase()

        return when (typeStr) {
            "normal"   -> Color.parseColor("#AABB99")
            "fire"     -> Color.parseColor("#FF4422")
            "water"    -> Color.parseColor("#3399FF")
            "electric" -> Color.parseColor("#FFCC33")
            "grass"    -> Color.parseColor("#77CC55")
            "ice"      -> Color.parseColor("#66CCFF")
            "fighting" -> Color.parseColor("#BB5544")
            "poison"   -> Color.parseColor("#AA5599")
            "ground"   -> Color.parseColor("#DDBB55")
            "flying"   -> Color.parseColor("#8899FF")
            "psychic"  -> Color.parseColor("#FF5599")
            "bug"      -> Color.parseColor("#AABB22")
            "rock"     -> Color.parseColor("#BBAA66")
            "ghost"    -> Color.parseColor("#6666BB")
            "dragon"   -> Color.parseColor("#7766EE")
            "dark"     -> Color.parseColor("#775544")
            "steel"    -> Color.parseColor("#AABBCC")
            "fairy"    -> Color.parseColor("#EE99EE")
            else       -> Color.TRANSPARENT
        }
    }

}
