package com.acom.acomemail.worker.validator

import com.acom.acomemail.data.EmailMessage
import com.acom.acomemail.util.enumi.ErrorEnum
import org.springframework.stereotype.Component

@Component
class EmailValidatorImpl : EmailValidator {

    override fun message(emailMessage: EmailMessage): ErrorEnum? {
        return missingDestinations(emailMessage.destinations)
            ?: missingSubject(emailMessage.subject)
            ?: missingContent(emailMessage.content)
    }

    fun missingDestinations(des: List<String>?): ErrorEnum? {
        if (des == null || des.isEmpty()) return ErrorEnum.MISSING_DESTINATIONS
        return null
    }

    fun missingSubject(subject: String?): ErrorEnum? {
        if (subject.isNullOrBlank()) return ErrorEnum.MISSING_SUBJECT
        return null
    }

    fun missingContent(content: String?): ErrorEnum? {
        if (content.isNullOrBlank()) return ErrorEnum.MISSING_CONTENT
        return null
    }
}