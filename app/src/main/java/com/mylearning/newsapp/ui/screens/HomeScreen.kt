package com.mylearning.newsapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mylearning.newsapp.data.entity.NewsResponse
import com.mylearning.newsapp.ui.components.Loader
import com.mylearning.newsapp.ui.components.NewsList
import com.mylearning.newsapp.viewmodel.NewsViewModel
import com.mylearning.utilities.ResourceState

@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    val newsResponse by newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        when (newsResponse) {
            is ResourceState.Loading -> {
                Loader()
                Log.d("TAG", "HomeScreen: inside loading")
            }

            is ResourceState.Success -> {
                val data = (newsResponse as ResourceState.Success<NewsResponse>).data
                Log.d("TAG", "HomeScreen: Inside success $data")
                NewsList(data)
            }

            is ResourceState.Error -> {
                Log.e("TAG", "HomeScreen: Inside error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}