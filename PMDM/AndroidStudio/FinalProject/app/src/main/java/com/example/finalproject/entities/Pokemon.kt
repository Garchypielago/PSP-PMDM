package com.example.finalproject.entities

data class Pokemon(
    val id: Int,
    val name: String,
    val description: String,
    val type1: Int,
    val type2: Int?,
    val region: Int,
    val legendary: Boolean,
    val stock: Int,
    val price: Double,
    val url: String
)
