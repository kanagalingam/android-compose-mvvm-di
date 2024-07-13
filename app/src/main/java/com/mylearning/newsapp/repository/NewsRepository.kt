package com.mylearning.newsapp.repository

import android.util.Log
import com.mylearning.newsapp.data.datasource.NewsDataSource
import com.mylearning.newsapp.data.entity.NewsResponse
import com.mylearning.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {
    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadline(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching data"))
            }
        }.catch {
            Log.d("TAG", it.localizedMessage)
            emit(ResourceState.Error(it.localizedMessage ?: "Some error in flow"))
        }
    }
}