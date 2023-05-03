package com.ai.astro.data.remote.repository

import com.ai.astro.common.Constants.BASE_URL
import com.ai.astro.data.remote.AstronautApi
import com.ai.astro.data.remote.response.Astronaut
import com.ai.astro.data.remote.response.AstronautDetail
import com.ai.astro.util.RetryInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AstronautRepository{

    private val apiService: AstronautApi = createApiService()

    // Function to get the list of items
    suspend fun getAstronauts(page: Int, pageSize: Int): List<Astronaut> {
        val response = apiService.getAstronauts(page, pageSize)
        return response.results.map {
            Astronaut(
                id = it.id,
                name = it.name,
                age = it.age,
                profileImageUrl = it.profileImageUrl
            )
        }
    }

    // Function to get an item by ID
    suspend fun getAstronautById(id: Int): AstronautDetail {
        val response = apiService.getAstronautById(id)
        return AstronautDetail(
            id = response.id,
            name = response.name,
            age = response.age,
            bio = response.bio,
            flightsCount = response.flightsCount,
            flights = response.flights,
            imageUrl = response.imageUrl
        )
    }

    private fun createApiService(): AstronautApi {
        val gson = GsonBuilder().create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(RetryInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(AstronautApi::class.java)
    }
}