package com.acom.acomtelegram.data

import com.acom.acomtelegram.util.enumi.ErrorEnum
import com.acom.acomtelegram.util.exception.ApiException
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponseModel private constructor(
    val status: Int,
    val error: ErrorEnum,
    val message: String,
    val stacktrace: String,
) {
    companion object {
        fun from(ex: ApiException) = ErrorResponseModel(
            ex.status.value(),
            ex.error,
            ex.localizedMessage,
            ex.stackTraceToString()
        )

        fun from(ex: Exception) = ErrorResponseModel(
            HttpStatus.NOT_FOUND.value(),
            ErrorEnum.UNKNOWN_ERROR,
            ex.localizedMessage,
            ex.stackTraceToString()
        )
    }
}
