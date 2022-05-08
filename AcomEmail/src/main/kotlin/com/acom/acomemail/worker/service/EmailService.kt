package com.acom.acomemail.worker.service

import com.acom.acomemail.data.EmailMessage

interface EmailService {
    fun sendMail(emailMessage: EmailMessage)
}