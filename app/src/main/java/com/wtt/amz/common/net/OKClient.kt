package com.wtt.amz.common.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal object OKClient {
    val instance: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor())
        .addInterceptor(HttpHeadInterceptor())
        .build()
}