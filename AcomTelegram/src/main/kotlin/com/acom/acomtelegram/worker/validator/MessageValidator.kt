package com.acom.acomtelegram.worker.validator

import com.acom.acomtelegram.data.TelegramMessage
import com.acom.acomtelegram.util.enumi.ErrorEnum

interface MessageValidator {

    /**
     * Kiểm tra yêu cầu gửi tin nhắn, quy tắc như sau:
     * - username not null và không được bỏ trống
     * - content not null và không được bỏ trống
     *
     * Created at 5/8/2022 by NCChinh
     */
    fun message(message: TelegramMessage): ErrorEnum?
}