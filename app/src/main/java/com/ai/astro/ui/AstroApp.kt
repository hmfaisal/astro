package com.ai.astro.ui

import android.app.Application
import androidx.room.Room
import com.ai.astro.common.Constants
import com.ai.astro.data.local.AstronautDatabase
import com.ai.astro.data.remote.AstronautApi
import com.ai.astro.util.RetryInterceptor
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
    }

    private fun initRetrofit() {
        val gson = GsonBuilder().create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(RetryInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()

        ApiService = Retrofit.Builder()
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

    companion object {
        lateinit var ApiService: AstronautApi
            private set

        lateinit var database: AstronautDatabase
            private set
    }
}

