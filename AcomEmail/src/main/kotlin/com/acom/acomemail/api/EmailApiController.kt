package com.acom.acomemail.api

import com.acom.acomemail.data.EmailMessage
import com.acom.acomemail.data.ResponseModel
import com.acom.acomemail.worker.service.EmailService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api")
class EmailApiController(
    private val emailService: EmailService
) {

    @PostMapping("/email")
    fun sendEmail(@RequestBody emailMessage: EmailMessage): ResponseModel {
        emailService.sendMail(emailMessage)

        return ResponseModel.ok("Email sent!")
    }
}