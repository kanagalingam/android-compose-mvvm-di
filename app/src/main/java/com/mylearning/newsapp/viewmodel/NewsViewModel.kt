package com.mylearning.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mylearning.newsapp.data.entity.NewsResponse
import com.mylearning.newsapp.repository.NewsRepository
import com.mylearning.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    // @Inject constructor is added because hilt needs
    // at-least one constructor to initialise the view model

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        Log.d(TAG, "init block of NewsViewModel called")
        getNews("us")
    }

    companion object {
        const val TAG = "NewsViewModel"
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country = country)
                .collectLatest { newsResponse ->
                    _news.value = newsResponse
                }
        }
    }

}