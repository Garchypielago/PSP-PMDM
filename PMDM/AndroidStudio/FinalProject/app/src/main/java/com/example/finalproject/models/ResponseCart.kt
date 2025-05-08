package com.example.finalproject.models

import com.example.finalproject.entities.CartPokemon

data class ResponseCart(
    val totalItems: Int = 0,
    val totalPrice: Double = 0.0,
    val products: List<CartPokemon> = emptyList()
)