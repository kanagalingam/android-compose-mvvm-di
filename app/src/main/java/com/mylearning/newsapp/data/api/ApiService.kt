package com.mylearning.newsapp.data.api

import com.mylearning.newsapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "f70a1a42aee5487b9bb2db96870023c5",
    ): Response<NewsResponse>

}