package com.acom.acomtelegram.worker.service

interface UserService {
    fun getByUsername(username: String): String
}