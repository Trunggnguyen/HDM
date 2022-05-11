package com.acom.acomemail.worker.service

import com.acom.acomemail.data.EmailMessage
import com.acom.acomemail.util.exception.ApiException
import com.acom.acomemail.worker.validator.EmailValidator
import org.springframework.http.HttpStatus
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(
    private val emailSender: JavaMailSender,
    private val emailValid: EmailValidator
) : EmailService {

    override fun sendMail(emailMessage: EmailMessage) {
        emailValid.message(emailMessage)?.let {
            throw ApiException()
                .status(HttpStatus.BAD_REQUEST)
                .error(it)
        }
        val message = SimpleMailMessage()

        message.setTo(*emailMessage.destinations!!.toTypedArray())
        message.setSubject(emailMessage.subject!!)
        message.setText(emailMessage.content!!)

        emailSender.send(message)
    }
}