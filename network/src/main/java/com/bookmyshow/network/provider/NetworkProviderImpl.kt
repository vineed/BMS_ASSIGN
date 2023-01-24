package com.bookmyshow.network.provider

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class NetworkProviderImpl : com.bookmyshow.core.NetworkProvider {

    private companion object {
        const val CONNECT_TIMEOUT = 30L
        const val READ_TIMEOUT = 30L
    }

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()

    override fun <ApiClass : Any> getApi(
        apiClass: Class<ApiClass>,
        baseUrl: String
    ): ApiClass {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(apiClass) as ApiClass
    }
}