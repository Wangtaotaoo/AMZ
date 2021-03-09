package com.wtt.amz.common.net

import android.util.Log
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

object PlainConvertFactory : Converter<ResponseBody, Page> {

    var factory = object : Converter.Factory() {
        override fun requestBodyConverter(
            type: Type,
            parameterAnnotations: Array<out Annotation>,
            methodAnnotations: Array<out Annotation>,
            retrofit: Retrofit
        ): Converter<*, RequestBody>? {
            return super.requestBodyConverter(
                type,
                parameterAnnotations,
                methodAnnotations,
                retrofit
            )
        }
    }

    override fun convert(value: ResponseBody): Page {
        Log.e("wttt", "convert:${value.string()} ")
        return Page("hhhh")
    }
}

data class Page(var content: String)