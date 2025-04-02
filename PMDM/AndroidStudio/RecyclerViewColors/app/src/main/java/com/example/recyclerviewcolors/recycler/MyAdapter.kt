package com.example.recyclerviewcolors.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcolors.MyColor
import com.example.recyclerviewcolors.R

class MyAdapter (private val dataSet: List<MyColor>) : RecyclerView.Adapter<MyView>() {

    var clickPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyView(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        if(position == clickPosition) {
            holder.tvColors.text = dataSet[position].getName()
            holder.tvColors.setTextColor(Color.parseColor(dataSet[position].getCode()))

            holder.tvCode.text = dataSet[position].getCode()
            holder.tvCode.setTextColor(Color.parseColor(dataSet[position].getCode()))

            holder.rowColor.setBackgroundColor(Color.WHITE)
        } else {
            holder.tvColors.text = dataSet[position].getName()
            holder.tvColors.setTextColor(Color.WHITE)

            holder.tvCode.text = dataSet[position].getCode()
            holder.tvCode.setTextColor(Color.WHITE)

            holder.rowColor.setBackgroundColor(Color.parseColor(dataSet[position].getCode()))
        }

        holder.rowColor.setOnClickListener{
            notifyItemChanged(clickPosition)
            clickPosition = position
            notifyItemChanged(clickPosition)
        }

        holder.rowColor.setOnLongClickListener{
            notifyItemChanged(clickPosition)
            clickPosition = -1
            notifyItemChanged(clickPosition)

            return@setOnLongClickListener true
        }
    }
}