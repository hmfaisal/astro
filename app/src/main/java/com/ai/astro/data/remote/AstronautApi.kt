package com.ai.astro.data.remote

import com.ai.astro.data.remote.dto.AstronautDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AstronautApi {
    // Endpoint for the list API
    @GET("astronaut/")
    suspend fun getAstronauts(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): AstronautApiResponse

    // Endpoint for the item API
    @GET("astronaut/{astronautId}")
    suspend fun getAstronautById(
        @Path("astronautId") id: Int
    ): AstronautDto

}