package com.ai.astro.data.local.astronaut.dao

import androidx.room.*
import com.ai.astro.data.local.astronaut.entity.AstronautEntity

@Dao
interface AstronautDao {

    @Query("SELECT * FROM astronauts LIMIT :pageSize OFFSET (:page - 1) * :pageSize")
    suspend fun getAstronauts(page: Int, pageSize: Int): List<AstronautEntity>

    @Query("SELECT * FROM astronauts WHERE id = :astronautId")
    suspend fun getAstronautById(astronautId: Int): AstronautEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAstronauts(astronauts: List<AstronautEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAstronaut(astronaut: AstronautEntity)

    @Query("DELETE FROM astronauts")
    suspend fun clearAstronauts()

}
