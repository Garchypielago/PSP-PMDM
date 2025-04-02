package com.example.recyclerviewcolors.model

import com.example.recyclerviewcolors.MyColor

class MainState {
    private val myColors = mutableListOf(
        MyColor("Red", "#FF0000"),
        MyColor("Blue", "#0000FF"),
        MyColor("Green", "#008000"),
        MyColor("Yellow", "#FFFF00"),
        MyColor("Orange", "#FFA500"),
        MyColor("Purple", "#800080"),
        MyColor("Pink", "#FFC0CB"),
        MyColor("Brown", "#A52A2A"),
        MyColor("Black", "#000000"),
        MyColor("White", "#FFFFFF"),
        MyColor("Gray", "#808080"),
        MyColor("Cyan", "#00FFFF"),
        MyColor("Magenta", "#FF00FF"),
        MyColor("Lime", "#00FF00"),
        MyColor("Olive", "#808000"),
        MyColor("Teal", "#008080"),
        MyColor("Navy", "#000080"),
        MyColor("Maroon", "#800000"),
        MyColor("Gold", "#FFD700"),
        MyColor("Silver", "#C0C0C0")
    )

    fun returnList(): List<MyColor>{
        return myColors;
    }

    fun delete(position : Int): MyData{
        myColors.removeAt(position)
        return MyData(position, myColors)
    }

    fun add(position: Int, name: String, code: String): MyData{
        myColors.add(position, MyColor(name, code))
        return MyData(position, myColors)
    }
}