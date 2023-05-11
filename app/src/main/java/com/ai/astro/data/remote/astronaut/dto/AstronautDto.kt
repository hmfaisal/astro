package com.ai.astro.data.remote.astronaut.dto

import com.google.gson.annotations.SerializedName

data class AstronautDto(
    val id: Int,
    val name: String,
    val age: Int,
    val bio: String,
    val nationality: String,
    val status: StatusDto,
    @SerializedName("flights_count")
    val flightsCount: Int?,
    val flights: List<FlightDto>?,
    @SerializedName("profile_image")
    val profileImageUrl: String?,
    @SerializedName("profile_image_thumbnail")
    val profileImageThumbnailUrl: String?
)
