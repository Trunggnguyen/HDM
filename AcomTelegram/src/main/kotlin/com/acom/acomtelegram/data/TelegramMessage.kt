package com.acom.acomtelegram.data

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TelegramMessage(
    val username: String? = null,
    val content: String? = null,
)
