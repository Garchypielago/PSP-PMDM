package com.example.finalproject.entities

data class CartPokemon (
    val id: Int,
    val productNumber: Int,
    val pokemonId: Int,
    val pokemonName: String,
    val url: String,
    val unitPrice: Double,
    val totalPrice: Double
)