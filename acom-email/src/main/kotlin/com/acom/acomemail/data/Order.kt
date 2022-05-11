package com.acom.acomemail.data

data class Order(
    val customer: Customer? = null,
    val products: List<Product>? = null,
    val shipment: Shipment? = null,
)