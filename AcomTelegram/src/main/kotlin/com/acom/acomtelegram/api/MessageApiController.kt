package com.acom.acomtelegram.api

import com.acom.acomtelegram.data.ResponseModel
import com.acom.acomtelegram.data.TelegramMessage
import com.acom.acomtelegram.worker.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api")
class MessageApiController(
    private val messageService: MessageService
) {

    @PostMapping("/message")
    fun sendMessage(@RequestBody message: TelegramMessage): ResponseModel {
        messageService.sendMessage(message)

        return ResponseModel.ok("Message sent!")
    }
}