package com.acom.acomprocess.entity

data class Order(
    val id: Long? = null,
    val customer: Customer? = null,
    val products: List<Product>? = null,
    val shipment: Shipment? = null,
) {
    companion object {
        private var generateId = 1L

        fun getId() = generateId++
    }
}
