package com.acom.acomtelegram.worker.bot

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class AcomBot : TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return "a"
    }

    override fun getBotUsername() = "acom_hdv_bot"

    override fun onUpdateReceived(update: Update?) {
        print(update?.message?.chatId)
    }

    companion object {
        private val bot by lazy { AcomBot() }

        fun getInstance() = bot
    }
}