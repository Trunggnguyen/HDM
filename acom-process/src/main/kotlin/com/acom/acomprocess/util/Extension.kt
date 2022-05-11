package com.acom.acomprocess.util

import org.springframework.http.HttpMethod
import org.springframework.web.client.HttpMessageConverterExtractor
import org.springframework.web.client.RestTemplate

fun <T> RestTemplate.putForObject(url: String, request: Any?, responseType: Class<T>): T? {
    val requestCallback = httpEntityCallback<Any>(request, responseType)
    val responseExtractor = HttpMessageConverterExtractor(responseType, messageConverters)
    return execute(url, HttpMethod.PUT, requestCallback, responseExtractor)
}
