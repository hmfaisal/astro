package com.ai.astro.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ai.astro.data.remote.dto.StatusDto

@Entity(tableName = "status")
data class StatusEntity(
    @PrimaryKey
    val id: Int,
    val name: String
){
    fun toDto() = StatusDto(
        id = id,
        name = name
    )
}
