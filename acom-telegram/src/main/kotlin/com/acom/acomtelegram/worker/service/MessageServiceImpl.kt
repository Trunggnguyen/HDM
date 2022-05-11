package com.acom.acomtelegram.worker.service

import com.acom.acomtelegram.data.TelegramMessage
import com.acom.acomtelegram.util.exception.ApiException
import com.acom.acomtelegram.worker.bot.AcomBot
import com.acom.acomtelegram.worker.validator.MessageValidator
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Service
class MessageServiceImpl(
    private val messageValid: MessageValidator
) : MessageService {

    override fun sendMessage(message: TelegramMessage) {
        messageValid.message(message)?.let {
            throw ApiException()
                .status(HttpStatus.BAD_REQUEST)
                .error(it)
        }

        val sendMsg = SendMessage()

        sendMsg.chatId = message.username!!
        sendMsg.text = message.content!!

        try {
            AcomBot.getInstance().execute(sendMsg)
        } catch (ex: TelegramApiException) {
            ex.printStackTrace()
        }
    }
}