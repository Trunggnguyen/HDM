package com.acom.acomcustomer.api

import com.acom.acomcustomer.entity.Customer
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/customer")
class CustomerApiController {

    val customers = listOf(
        Customer(1L, "Nguyễn Công Chính", "Hà Nội", "0123456789", "cn20082000@gmail.com", "1988889962"),
        Customer(2L, "Phạm Đức Minh", "Hà Nội", "0936724836",  "cn20082000@gmail.com", "1988889962"),
        Customer(3L, "Nguyễn Văn Trung", "Hà Nội", "0838887819", "trungvannguyen282@gmail.com", "5082071575"),
    )

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Long): Customer? {
        return customers.firstOrNull { c -> c.id == id }
    }
}