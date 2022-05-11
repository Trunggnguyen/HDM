package com.acom.acomtelegram.api

import com.acom.acomtelegram.data.Customer
import com.acom.acomtelegram.data.ResponseModel
import com.acom.acomtelegram.data.TelegramMessage
import com.acom.acomtelegram.worker.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping
class MessageApiController(
    private val messageService: MessageService
) {

    @PostMapping
    fun sendMessage(@RequestBody customer: Customer): ResponseModel {
        val message = TelegramMessage(
            customer.telegramId,
            "Cảm ơn bạn đã mua hàng tại Acom,\n" +
                    "Vui lòng kiểm tra email để biết thêm chi tiết hóa đơn."
        )
        messageService.sendMessage(message)

        return ResponseModel.ok("Message sent!")
    }
}