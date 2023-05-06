package com.ai.astro.ui

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ai.astro.common.Constants
import com.ai.astro.data.local.AstronautDatabase
import com.ai.astro.data.remote.AstronautApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AstroApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRetrofit()
        initDatabase()
        initSharedPreferences()
    }

    private fun initRetrofit() {
        val gson = GsonBuilder().create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            //.addInterceptor(RetryInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(AstronautApi::class.java)
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
    }
}

