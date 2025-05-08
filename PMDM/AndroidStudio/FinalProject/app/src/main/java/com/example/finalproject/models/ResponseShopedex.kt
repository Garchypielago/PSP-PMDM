package com.example.finalproject.models

import com.example.finalproject.entities.Pageable
import com.example.finalproject.entities.Pokemon
import com.example.finalproject.entities.Sort

data class ResponseShopedex(
    val content: List<Pokemon> = emptyList(),
    val pageable: Pageable = Pageable(),
    val last: Boolean = false,
    val totalElements: Int = 0,
    val totalPages: Int = 0,
    val size: Int = 0,
    val number: Int = 0,
    val sort: Sort = Sort(),
    val first: Boolean = true,
    val numberOfElements: Int = 0,
    var empty: Boolean = true
)
