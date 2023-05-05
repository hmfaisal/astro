package com.ai.astro.data.repository

import com.ai.astro.data.local.dao.AstronautDao
import com.ai.astro.data.local.entity.AstronautEntity
import com.ai.astro.data.local.entity.FlightEntity
import com.ai.astro.data.local.entity.StatusEntity
import com.ai.astro.data.remote.AstronautApi
import com.ai.astro.data.remote.dto.AstronautDto
import com.ai.astro.ui.AstroApp

class AstronautRepository(
    private val apiService: AstronautApi = AstroApp.ApiService,
    private val astronautDao: AstronautDao = AstroApp.database.astronautDao()
){

    // Function to get the list of items
    suspend fun getAstronauts(page: Int, pageSize: Int): List<AstronautDto> {
        val astronauts = astronautDao.getAstronauts(page, pageSize)
        if (astronauts.isEmpty()) {
            // Fetch data from API and save to local database
            val response = apiService.getAstronauts(pageSize, page * pageSize)
            val astronautEntities = response.results.map {
                AstronautEntity(
                    id = it.id,
                    name = it.name,
                    age = it.age,
                    bio = it.bio,
                    nationality = it.nationality,
                    status = StatusEntity(
                        id = it.status.id,
                        name = it.status.name
                    ),
                    flightsCount = it.flightsCount,
                    flights = it.flights?.map { flightDto ->
                        FlightEntity(
                            id = flightDto.id,
                            name = flightDto.name
                        )
                    },
                    profileImageUrl = it.profileImageUrl,
                    profileImageThumbnailUrl = it.profileImageThumbnailUrl
                )
            }
            astronautDao.insertAstronauts(astronautEntities)
            return response.results
        } else {
            return astronauts.map {
                it.toDto()
            }
        }
    }

    // Function to get an item by ID
    suspend fun getAstronautById(astronautId: Int): AstronautDto {
        try {
            val response = apiService.getAstronautById(astronautId)
            val astronautEntity = AstronautEntity(
                id = response.id,
                name = response.name,
                age = response.age,
                bio = response.bio,
                nationality = response.nationality,
                status = StatusEntity(
                    id = response.status.id,
                    name = response.status.name
                ),
                flightsCount = response.flightsCount,
                flights = response.flights?.map { flightDto ->
                    FlightEntity(
                        id = flightDto.id,
                        name = flightDto.name
                    )
                },
                profileImageUrl = response.profileImageUrl,
                profileImageThumbnailUrl = response.profileImageThumbnailUrl
            )
            astronautDao.insertAstronaut(astronautEntity)
            return astronautEntity.toDto()
        } catch (e: Exception) {
            val astronautEntity = astronautDao.getAstronautById(astronautId)
            if (astronautEntity == null) {
                throw e
            } else {
                return astronautEntity.toDto()
            }
        }
    }

}