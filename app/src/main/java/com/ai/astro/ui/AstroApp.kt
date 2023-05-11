package com.ai.astro.ui

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ai.astro.data.local.astronaut.AstronautDatabase
import com.ai.astro.data.remote.OpenAiApi
import com.ai.astro.data.remote.astronaut.AstronautApi
import com.ai.astro.data.remote.astronaut.AstronautApiClient
import com.ai.astro.data.remote.openai.OpenAiApiClient


class AstroApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRetrofit()
        initOpenAIApi()
        initDatabase()
        initSharedPreferences()
    }

    private fun initRetrofit() {
        apiService = AstronautApiClient.createAstronautApiService()
    }

    private fun initOpenAIApi(){
        openAiApiService = OpenAiApiClient.createOpenAiApiService()
    }

    private fun initDatabase() {
        database = Room.databaseBuilder(
            applicationContext,
            AstronautDatabase::class.java,
            "astronaut_database"
        ).build()
    }

    private fun initSharedPreferences() {
        sharedPreferences = getSharedPreferences("AstroApp", Context.MODE_PRIVATE)
    }

    companion object {
        lateinit var apiService: AstronautApi
            private set

        lateinit var database: AstronautDatabase
            private set

        lateinit var sharedPreferences: SharedPreferences
            private set

        lateinit var openAiApiService: OpenAiApi
            private set
    }
}

