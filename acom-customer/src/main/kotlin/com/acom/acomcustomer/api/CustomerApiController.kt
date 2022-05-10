package com.acom.acomcustomer.api

import com.acom.acomcustomer.entity.Customer
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping
class CustomerApiController {

    val customers = listOf(
        Customer(1L, "Nguyễn Công Chính", "Hà Nội", "cn20082000@gmail.com", "1988889962"),
        Customer(2L, "Phạm Đức Minh", "Hà Nội", "cn20082000@gmail.com", "1988889962"),
        Customer(3L, "Nguyễn Văn Trung", "Hà Nội", "cn20082000@gmail.com", "1988889962"),
    )

    @GetMapping(params = ["id"])
    fun getCustomer(@RequestParam id: Long): Customer? {
        return customers.firstOrNull { p -> p.id == id }
    }
}