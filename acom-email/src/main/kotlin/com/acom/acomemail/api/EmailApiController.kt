package com.acom.acomemail.api

import com.acom.acomemail.data.EmailMessage
import com.acom.acomemail.data.Order
import com.acom.acomemail.data.ResponseModel
import com.acom.acomemail.worker.service.EmailService
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@CrossOrigin
@RequestMapping
class EmailApiController(
    private val emailService: EmailService
) {

    @PostMapping
    fun sendEmail(@RequestBody order: Order): ResponseModel {
        var content = """
            Cảm ơn bạn đã mua hàng tại Acom,
            Đơn hàng của bạn sẽ sớm được giao tới địa chỉ: ${order.customer?.address}.
            Vui lòng kiểm tra thông báo thường xuyên để biết thời gian nhận hàng nhé.
            Chi tiết hóa đơn:
            Tên mặt hàng,    Số lượng,    Đơn giá,
        """.trimIndent()
        order.products?.let {
            it.forEach { product ->
                content += "\n${product.name},\t${product.quantity},\t${BigDecimal(product.price!!).toPlainString()} VND,"
            }
            content += "\nThành tiền: ${BigDecimal(it.sumOf { p -> p.price!! }).toPlainString()} VND"
        }

        val emailMessage = EmailMessage(
            listOf(order.customer?.email!!),
            "Acom - Mua hàng thành công",
            content
        )
        emailService.sendMail(emailMessage)

        return ResponseModel.ok("Email sent!")
    }
}