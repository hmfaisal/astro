package com.ai.astro.data.repository

import com.ai.astro.data.local.astronaut.dao.AstronautDao
import com.ai.astro.data.mapper.AstronautMapper
import com.ai.astro.data.remote.astronaut.AstronautApi
import com.ai.astro.model.astronaut.Astronaut
import com.ai.astro.ui.AstroApp

class AstronautRepository(
    private val apiService: AstronautApi = AstroApp.apiService,
    private val astronautDao: AstronautDao = AstroApp.database.astronautDao(),
    private val astronautMapper: AstronautMapper = AstronautMapper()
) {

    // Function to get the list of items
    suspend fun getAstronauts(page: Int, pageSize: Int): List<Astronaut> {
        try {
            val astronauts = astronautDao.getAstronauts(page, pageSize)
            if (astronauts.isEmpty()) {
                // Fetch data from API and save to local database
                val response = apiService.getAstronauts(pageSize, page * pageSize)
                val astronautEntities = response.results.map {astronautDto ->
                    astronautMapper.mapAstronautDtoToEntity(astronautDto)
                }
                astronautDao.insertAstronauts(astronautEntities)
                return astronautEntities.map { astronautEntity ->
                    astronautMapper.mapAstronautEntityToDomain(astronautEntity)
                }
            } else {
                return astronauts.map { astronautEntity ->
                    astronautMapper.mapAstronautEntityToDomain(astronautEntity)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Log the stack trace for debugging purposes
            return emptyList()
        }
    }


    // Function to get an item by ID
    suspend fun getAstronautById(astronautId: Int): Astronaut {
        try {
            val astronaut = astronautDao.getAstronautById(astronautId)
            if (astronaut == null || astronaut.flights.isNullOrEmpty()) {
                val response = apiService.getAstronautById(astronautId)
                val astronautEntity = astronautMapper.mapAstronautDtoToEntity(response)
                astronautDao.insertAstronaut(astronautEntity)
                return astronautMapper.mapAstronautEntityToDomain(astronautEntity)
            } else {
                return astronautMapper.mapAstronautEntityToDomain(astronaut)
            }
        } catch (e: Exception) {
            val astronaut = astronautDao.getAstronautById(astronautId)
            if (astronaut == null) {
                throw e
            } else {
                return astronautMapper.mapAstronautEntityToDomain(astronaut)
            }
        }
    }
}