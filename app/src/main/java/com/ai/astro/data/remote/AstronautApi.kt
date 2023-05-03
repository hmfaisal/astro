package com.ai.astro.data.remote

import com.ai.astro.data.remote.response.AstronautDetail
import com.ai.astro.data.remote.response.AstronautList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AstronautApi {
    // Endpoint for the list API
    @GET("astronaut/")
    suspend fun getAstronauts(
        @Query("offset") page: Int,
        @Query("limit") pageSize: Int
    ): AstronautList

    // Endpoint for the item API
    @GET("astronaut/{astronautId}")
    suspend fun getAstronautById(
        @Path("astronautId") id: Int
    ): AstronautDetail

}