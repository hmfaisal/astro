package com.ai.astro.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ai.astro.data.remote.dto.AstronautDto

@Entity(tableName = "astronauts")
data class AstronautEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int,
    val bio: String,
    val nationality: String,
    val status: StatusEntity,
    val flightsCount: Int?,
    val flights: List<FlightEntity>?,
    val profileImageUrl: String?,
    val profileImageThumbnailUrl: String?
)
