package com.acom.acomemail.worker.handler

import com.acom.acomemail.data.ErrorResponseModel
import com.acom.acomemail.data.ResponseModel
import com.acom.acomemail.util.exception.ApiException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ApiException::class)
    fun apiException(ex: ApiException) = ResponseEntity
        .status(ex.status)
        .body(ResponseModel.error(ErrorResponseModel.from(ex)))

    @ExceptionHandler(Exception::class)
    fun unknownException(ex: Exception) = ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ResponseModel.error(ErrorResponseModel.from(ex)))
}