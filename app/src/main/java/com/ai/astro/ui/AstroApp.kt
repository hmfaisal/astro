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

    companion object {
        lateinit var apiService: AstronautApi
        lateinit var database: AstronautDatabase
    }

    override fun onCreate() {
        super.onCreate()

        val gson = GsonBuilder().create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(RetryInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(AstronautApi::class.java)

        database = Room.databaseBuilder(
            applicationContext,
            AstronautDatabase::class.java,
            "astronaut_database"
        ).build()
    }
}
