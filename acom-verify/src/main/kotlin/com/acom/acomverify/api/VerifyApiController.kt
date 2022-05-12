package com.acom.acomverify.api

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@CrossOrigin
@RequestMapping("/verify")
class VerifyApiController {

    val customers = listOf(
        "bXVcD1fQgSA5l8QHLaSj",
        "wLIg2YtvYv9z60eFOka9",
        "HHLlqrEisxL3AGPCdxes",
    )

    @PostMapping
    fun verify(request: HttpServletRequest): Long {
        val token = request.getHeader("BEAR_TOKEN") ?: ""
        val index = customers.indexOf(token) + 1
        return index.toLong()
    }
}