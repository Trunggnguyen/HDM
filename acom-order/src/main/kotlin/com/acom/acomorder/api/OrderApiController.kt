package com.acom.acomorder.api

import com.acom.acomorder.entity.Order
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping
class OrderApiController {

    val orders = mutableListOf<Order>()

    @PostMapping
    fun createOrder(@RequestBody order: Order): Order {
        orders.add(Order(Order.getId(), order.customer, order.products, order.shipment))
        return orders.last()
    }
}