package com.mylearning.newsapp;

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp


// Add `android:name=".NewsApplication" under application tag in Manifest file
@HiltAndroidApp
class NewsApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application onCreated called")
    }

    companion object{
        const val TAG = "NewsApplication"
    }
}