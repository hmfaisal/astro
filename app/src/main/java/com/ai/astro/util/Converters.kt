package com.ai.astro.util

import androidx.room.TypeConverter
import com.ai.astro.data.local.astronaut.entity.FlightEntity
import com.ai.astro.data.local.astronaut.entity.StatusEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromFlightEntityList(value: List<FlightEntity>?): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toFlightEntityList(value: String?): List<FlightEntity>? {
        val listType = object : TypeToken<List<FlightEntity>?>() {}.type
        return value?.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromStatusEntity(value: StatusEntity): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toStatusEntity(value: String): StatusEntity? {
        val listType = object : TypeToken<StatusEntity?>() {}.type
        return value?.let { Gson().fromJson(it, listType) }
    }
}
