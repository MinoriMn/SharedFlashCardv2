package com.gmail.kamemaru2011.app

import android.app.Application
import com.gmail.kamemaru2011.utils.LogUtils

class SharedFlashCardApp : Application() {
    //TODO Retrofit
    override fun onCreate() {
        super.onCreate()

        setupApiClient()
    }

    private fun setupApiClient(){
        LogUtils.d("SharedFlashCardApp#setupApiClient", "Start")
    }
}