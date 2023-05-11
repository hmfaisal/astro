package com.ai.astro.data.local.astronaut

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ai.astro.data.local.astronaut.dao.AstronautDao
import com.ai.astro.data.local.astronaut.entity.AstronautEntity
import com.ai.astro.util.Converters

@Database(entities = [AstronautEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AstronautDatabase : RoomDatabase() {
    abstract fun astronautDao(): AstronautDao
}