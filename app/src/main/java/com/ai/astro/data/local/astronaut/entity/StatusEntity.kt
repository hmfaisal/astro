package com.ai.astro.data.local.astronaut.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ai.astro.data.remote.astronaut.dto.StatusDto

@Entity(tableName = "status")
data class StatusEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)
