package com.acom.acomemail.data

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class EmailMessage(
    val destinations: List<String>? = null,
    val subject: String? = null,
    val content: String? = null,
)
