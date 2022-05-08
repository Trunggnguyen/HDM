package com.acom.acomemail.util.exception

import com.acom.acomemail.util.enumi.ErrorEnum
import org.springframework.http.HttpStatus

class ApiException(
    val status: HttpStatus = HttpStatus.NOT_FOUND,
    val error: ErrorEnum = ErrorEnum.UNKNOWN_ERROR
) : RuntimeException(error.name) {

    fun status(status: HttpStatus) = ApiException(status, error)

    fun error(error: ErrorEnum) = ApiException(status, error)
}