package com.acom.acomprocess.api

import com.acom.acomprocess.entity.Customer
import com.acom.acomprocess.entity.Order
import com.acom.acomprocess.entity.Product
import com.acom.acomprocess.entity.Shipment
import com.acom.acomprocess.util.putForObject
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.util.MultiValueMap
import org.springframework.util.MultiValueMapAdapter
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import javax.servlet.http.HttpServletRequest

@RestController
@CrossOrigin
@RequestMapping("/process")
class ProcessApiController {

    val restTemplate = RestTemplate()
    val verifyUrl = "http://localhost:8090/verify"
    val customerUrl = "http://localhost:8091/customer"
    val productUrl = "http://localhost:8092/product"
    val shipmentUrl = "http://localhost:8093/shipment"
    val orderUrl = "http://localhost:8094/order"
    val emailUrl = "http://localhost:8095/email"
    val telegramUrl = "http://localhost:8096/telegram"

    @PostMapping
    fun process(@RequestBody order: Order, request: HttpServletRequest): String {

        // validate customer
        val token = request.getHeader("BEAR_TOKEN") ?: ""
        val header = HttpHeaders()
        header.set("BEAR_TOKEN", token)
        val customerHttpEntity = HttpEntity(null, header)
        val customerId = restTemplate.postForObject(verifyUrl, customerHttpEntity, Long::class.java) ?: 0
        if (customerId <= 0) {
            return "Failed! Login required"
        }
        val customer = restTemplate.getForObject("$customerUrl/$customerId", Customer::class.java)
            ?: return "Failed! Customer not found!"

        // validate products
        val products = mutableListOf<Product>()
        order.products?.let {
            for (p in it) {
                val product = restTemplate.getForObject("$productUrl/${p.id}", Product::class.java)
                    ?: return "Failed! Product ${p.name} not found!"
                if (product.quantity < p.quantity) {
                    return "Failed! The quantity of ${p.name} is not enough!"
                }
                product.quantity = p.quantity
                products.add(product)
            }
        }

        // validate shipment
        val shipment = restTemplate.getForObject("$shipmentUrl/${order.shipment?.id}", Shipment::class.java)
            ?: return "Failed! Shipment not found!"

        // save order
        val validatedOrder = Order(customer, products, shipment)
        val httpEntity = HttpEntity(validatedOrder, null)
        restTemplate.postForObject(orderUrl, httpEntity, Order::class.java)

        // update product quantity
        validatedOrder.products?.let {
            for (p in it) {
                val productHttpEntity = HttpEntity(p, null)
                restTemplate.putForObject("$productUrl/${p.id}", productHttpEntity, Product::class.java)
            }
        }

        // send email
        val emailHttpEntity = HttpEntity(validatedOrder, null)
        restTemplate.postForObject(emailUrl, emailHttpEntity, String::class.java)

        // send telegram message
        val telegramHttpEntity = HttpEntity(validatedOrder.customer, null)
        restTemplate.postForObject(telegramUrl, telegramHttpEntity, String::class.java)

        return "Success"
    }
}