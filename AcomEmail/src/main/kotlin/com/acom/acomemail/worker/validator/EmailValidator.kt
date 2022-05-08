package com.acom.acomemail.worker.validator

import com.acom.acomemail.data.EmailMessage
import com.acom.acomemail.util.enumi.ErrorEnum

interface EmailValidator {

    /**
     * Kiểm tra yêu cầu gửi email, quy tắc như sau:
     * - destinations có ít nhất 1 địa chỉ
     * - subject not null và không được bỏ trống
     * - content not null và không được bỏ trống
     *
     * Created at 5/7/2022 by NCChinh
     */
    fun message(emailMessage: EmailMessage): ErrorEnum?
}