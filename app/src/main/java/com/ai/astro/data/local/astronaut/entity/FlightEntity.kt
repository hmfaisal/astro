package com.ai.astro.data.local.astronaut.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ai.astro.data.remote.astronaut.dto.FlightDto

@Entity(tableName = "flights")
data class FlightEntity(
    @PrimaryKey
    val id: String,
    val name: String
)
