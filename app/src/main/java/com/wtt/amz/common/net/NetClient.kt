package com.wtt.amz.common.net

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object NetClient {
    fun getInstance(): MainPageApi =
        Retrofit.Builder()
            .baseUrl("https://www.mzitu.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(OKClient.instance)
            .build()
            .create(MainPageApi::class.java)
}