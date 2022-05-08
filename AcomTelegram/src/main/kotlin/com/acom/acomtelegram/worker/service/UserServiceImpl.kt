package com.acom.acomtelegram.worker.service

import com.acom.acomtelegram.common.FakeData
import com.acom.acomtelegram.util.enumi.ErrorEnum
import com.acom.acomtelegram.util.exception.ApiException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    override fun getByUsername(username: String): String {
        return FakeData.phonebook[username]
            ?: throw ApiException()
                .status(HttpStatus.NOT_FOUND)
                .error(ErrorEnum.UNKNOWN_USER)
    }
}