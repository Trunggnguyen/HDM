package com.acom.acomtelegram.worker.service

import com.acom.acomtelegram.data.TelegramMessage

interface MessageService {
    fun sendMessage(message: TelegramMessage)
}