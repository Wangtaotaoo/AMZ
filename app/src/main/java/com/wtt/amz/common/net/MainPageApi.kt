package com.wtt.amz.common.net

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface MainPageApi {
    @GET("/page/{pageCount}/")
    suspend fun listPage(@Path("pageCount") page: Int): ResponseBody
}