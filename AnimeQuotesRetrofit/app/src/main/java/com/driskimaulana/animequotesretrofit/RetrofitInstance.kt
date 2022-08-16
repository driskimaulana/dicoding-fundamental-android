package com.driskimaulana.animequotesretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api : AnimeQuotesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://animechan.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeQuotesApi::class.java)
    }

}