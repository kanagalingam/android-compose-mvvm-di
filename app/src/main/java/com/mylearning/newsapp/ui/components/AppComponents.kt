package com.mylearning.newsapp.ui.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mylearning.newsapp.data.entity.NewsResponse


@Composable
fun Loader() {
    val progressValue = 0.99f
    val infiniteTransition = rememberInfiniteTransition(label = "Loading")

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue, animationSpec = infiniteRepeatable(animation = tween(1200)),
        label = ""
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, // Align horizontally to the center
        verticalArrangement = Arrangement.Center // Align vertically to the center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp), // Reduced size
            progress = progressAnimationValue
        )
    }
}

@Composable
fun NewsList(response: NewsResponse){
    LazyColumn{
        items(response.articles?.size ?: 0){

        }

    }
}

@Composable
fun NormalTextComponent(){

}