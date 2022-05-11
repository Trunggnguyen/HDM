package com.acom.acomtelegram.worker.validator

import com.acom.acomtelegram.data.TelegramMessage
import com.acom.acomtelegram.util.enumi.ErrorEnum
import org.springframework.stereotype.Component

@Component
class MessageValidatorImpl : MessageValidator {

    override fun message(message: TelegramMessage): ErrorEnum? {
        return missingUsername(message.username)
            ?: missingContent(message.content)
    }

    fun missingUsername(username: String?): ErrorEnum? {
        if (username.isNullOrBlank()) return ErrorEnum.MISSING_USERNAME
        return null
    }

    fun missingContent(content: String?): ErrorEnum? {
        if (content.isNullOrBlank()) return ErrorEnum.MISSING_CONTENT
        return null
    }
}