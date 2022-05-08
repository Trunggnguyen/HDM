package com.acom.acomtelegram.common.config

import com.acom.acomtelegram.worker.bot.AcomBot
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import javax.annotation.PostConstruct

@Configuration
class AcomBotConfig {

    @PostConstruct
    fun start() {
        try {
            val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
            telegramBotsApi.registerBot(AcomBot.getInstance())
        } catch (ex: TelegramApiException) {
            ex.printStackTrace()
        }
    }
}