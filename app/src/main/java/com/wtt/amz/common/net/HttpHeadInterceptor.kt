package com.wtt.amz.common.net

import okhttp3.Interceptor
import okhttp3.Response

class HttpHeadInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36")
            .build()
        return chain.proceed(request)
    }
}