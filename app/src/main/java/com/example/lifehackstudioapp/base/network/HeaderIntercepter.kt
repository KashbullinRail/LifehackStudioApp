package com.example.newsfetcher.base.network

import okhttp3.Interceptor
import okhttp3.Response


class HeaderIntercepter : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        return chain.proceed(builder.build())
    }

}