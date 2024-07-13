package com.mylearning.newsapp.data.datasource

import com.mylearning.newsapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}