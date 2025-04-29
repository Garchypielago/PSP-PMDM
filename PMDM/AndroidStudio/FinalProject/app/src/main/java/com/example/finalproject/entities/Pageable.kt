package com.example.finalproject.entities

data class Pageable(
    val pageNumber: Int = 0,
    val pageSize: Int = 10,
    val sort: Sort = Sort(),
    val offset: Int = 0,
    val paged: Boolean = true,
    val unpaged: Boolean = false
)