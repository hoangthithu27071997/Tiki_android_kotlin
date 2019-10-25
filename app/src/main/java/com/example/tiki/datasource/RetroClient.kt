package com.example.tiki.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {

    private val ROOT_URL = "https://raw.githubusercontent.com/"

    private val retrofitInstance: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService: ApiService
        get() = retrofitInstance.create(ApiService::class.java)
}