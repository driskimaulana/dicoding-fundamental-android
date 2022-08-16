package com.driskimaulana.animequotesretrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeQuotesApi {
    @GET("/api/random")
    suspend fun getRandomQuotes() : Response<Quote>

    @GET("/api/quotes")
    suspend fun getTenQuotes() : Response<List<Quote>>

    @GET("/api/available/anime")
    suspend fun getAvailableAnime() : Response<List<String>>

    @GET("/api/quotes/anime?")
    suspend fun getQuotesByAnime(@Query("title") title: String) : Response<List<Quote>>
}