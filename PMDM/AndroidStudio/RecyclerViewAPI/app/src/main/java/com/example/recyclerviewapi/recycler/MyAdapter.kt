package com.example.recyclerviewapi.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewapi.R
import com.example.recyclerviewapi.model.ResponseDog

class MyAdapter (private val dataSet : ResponseDog) : RecyclerView.Adapter<MyView>() {

    lateinit var myContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        myContext = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)

        return MyView(view)
    }

    override fun getItemCount() = dataSet.message!!.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val url : String = dataSet.message!![position]
        Glide.with(myContext)
            .load(url)
            .into(holder.imV1);
    }
}