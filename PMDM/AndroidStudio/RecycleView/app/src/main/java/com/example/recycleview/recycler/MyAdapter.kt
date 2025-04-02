package com.example.recycleview.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R

class MyAdapter (private val dataSet: List<String>) : RecyclerView.Adapter<MyView>() {

    var clickPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyView(view)
    }

//    override fun getItemCount(): Int {
//        return dataSet.size
//    }
    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.tvPokemons.text = dataSet[position]

        if(position == clickPosition){
            holder.tvPokemons.setTextColor(Color.BLACK)
            holder.tvPokemons.setBackgroundColor(Color.CYAN)
        } else {
            holder.tvPokemons.setTextColor(Color.WHITE)
            holder.tvPokemons.setBackgroundColor(Color.BLACK)
        }

        holder.tvPokemons.setOnClickListener{
            notifyItemChanged(clickPosition)
            clickPosition = position
            notifyItemChanged(clickPosition)
        }



    }
}