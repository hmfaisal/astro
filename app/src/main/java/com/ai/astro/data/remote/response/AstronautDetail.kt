package com.ai.astro.data.remote.response

import com.google.gson.annotations.SerializedName

data class AstronautDetail(
    val id: Int,
    val name: String,
    val age: Int,
    val bio: String,
    @SerializedName("flights_count")
    val flightsCount: Int,
    val flights: List<Flight>,
    @SerializedName("profile_image")
    val imageUrl: String?
)
