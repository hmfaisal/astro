package com.ai.astro.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ai.astro.data.local.dao.AstronautDao
import com.ai.astro.data.local.entity.AstronautEntity
import com.ai.astro.util.Converters

@Database(entities = [AstronautEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AstronautDatabase : RoomDatabase() {
    abstract fun astronautDao(): AstronautDao
}