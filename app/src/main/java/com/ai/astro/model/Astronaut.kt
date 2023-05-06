package com.ai.astro.model

data class Astronaut(
    val id: Int,
    val name: String,
    val age: Int,
    val bio: String,
    val nationality: String,
    val status: Status,
    val flightsCount: Int?,
    val flights: List<Flight>?,
    val profileImageUrl: String?,
    val profileImageThumbnailUrl: String?
)
