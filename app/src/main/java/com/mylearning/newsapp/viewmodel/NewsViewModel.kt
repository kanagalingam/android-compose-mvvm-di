package com.mylearning.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {
    // @Inject constructor is added because hilt needs
    // at-least one constructor to initialise the view model

    init {
        Log.d(TAG, "init block of NewsViewModel called")
    }

    companion object{
       const val TAG = "NewsViewModel"
    }

}