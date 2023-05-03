package com.ai.astro.util

import okhttp3.Interceptor
import okhttp3.Response

class RetryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var response = chain.proceed(request)
        var tryCount = 0
        while (response.code == 429 && tryCount < 15) {
            tryCount++
            Thread.sleep((1000 * tryCount).toLong())
            response = chain.proceed(request)
        }
        return response
    }
}