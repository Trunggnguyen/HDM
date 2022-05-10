package com.acom.acomproduct.entity

data class Product(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    var quantity: Int = 0,
)
