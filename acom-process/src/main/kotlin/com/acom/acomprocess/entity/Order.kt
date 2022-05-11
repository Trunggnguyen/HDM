package com.acom.acomprocess.entity

data class Order(
    val customer: Customer? = null,
    val products: List<Product>? = null,
    val shipment: Shipment? = null,
)