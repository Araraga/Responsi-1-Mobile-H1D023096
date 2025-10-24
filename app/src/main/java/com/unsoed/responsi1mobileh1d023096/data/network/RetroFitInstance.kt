package com.unsoed.responsi1mobileh1d023096.data.network

import com.unsoed.responsi1mobileh1d023096.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val authInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-Auth-Token", Constants.API_KEY)
            .build()
        chain.proceed(request)
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: FootballApi by lazy {
        retrofit.create(FootballApi::class.java)
    }
}