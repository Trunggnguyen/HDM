package com.acom.acomprocess.api

import com.acom.acomprocess.entity.Customer
import com.acom.acomprocess.entity.Order
import com.acom.acomprocess.entity.Product
import com.acom.acomprocess.entity.Shipment
import com.acom.acomprocess.util.putForObject
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@RestController
@CrossOrigin
@RequestMapping
class ProcessApiController {

    val restTemplate = RestTemplate()

    val productUrl = "http://localhost:8090"
    val customerUrl = "http://localhost:8091"
    val shipmentUrl = "http://localhost:8092"
    val orderUrl = "http://localhost:8093"

    @PostMapping
    fun process(@RequestBody order: Order): String {

        // validate customer
        val customer = restTemplate.getForObject("$customerUrl?id=${order.customer?.id}", Customer::class.java)
            ?: return "Failed! Customer not found!"

        // validate products
        val products = mutableListOf<Product>()
        order.products?.let {
//            val distinctProducts = it.toMutableList()
//            for (i1 in 0..distinctProducts.size) {
//                for (i2 in i1..distinctProducts.size) {
//                }
//            }
            for (p in it) {
                val product = restTemplate.getForObject("$productUrl?id=${p.id}", Product::class.java)
                    ?: return "Failed! Product ${p.name} not found!"
                if (product.quantity < p.quantity) {
                    return "Failed! The quantity of ${p.name} is not enough!"
                }
                product.quantity -= p.quantity
                products.add(product)
            }
        }

        // validate shipment
        val shipment = restTemplate.getForObject("$shipmentUrl?id=${order.shipment?.id}", Shipment::class.java)
            ?: return "Failed! Shipment not found!"

        // save order
        val validatedOrder = Order(customer, products, shipment)
        val httpEntity = HttpEntity(validatedOrder, null)
        val responseOrder = restTemplate.postForObject(orderUrl, httpEntity, Order::class.java)

        // update product quantity
        responseOrder?.products?.let {
            for (p in it) {
                val productHttpEntity = HttpEntity(p, null)
                restTemplate.putForObject(productUrl, productHttpEntity, Product::class.java)
            }
        }

        return "Success"
    }
}