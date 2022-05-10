package com.acom.acomprocess.entity

data class Product(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    var quantity: Int = 0,
    val price: Double? = null,
)
