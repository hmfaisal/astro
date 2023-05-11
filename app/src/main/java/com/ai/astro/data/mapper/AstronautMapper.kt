package com.ai.astro.data.mapper

import com.ai.astro.data.local.astronaut.entity.AstronautEntity
import com.ai.astro.data.local.astronaut.entity.FlightEntity
import com.ai.astro.data.local.astronaut.entity.StatusEntity
import com.ai.astro.data.remote.astronaut.dto.AstronautDto
import com.ai.astro.data.remote.astronaut.dto.FlightDto
import com.ai.astro.data.remote.astronaut.dto.StatusDto
import com.ai.astro.model.astronaut.Astronaut
import com.ai.astro.model.astronaut.Flight
import com.ai.astro.model.astronaut.Status

class AstronautMapper {
    fun mapAstronautDtoToEntity(dto: AstronautDto): AstronautEntity {
        return AstronautEntity(
            id = dto.id,
            name = dto.name,
            age = dto.age,
            bio = dto.bio,
            nationality = dto.nationality,
            status = mapStatusDtoToEntity(dto.status),
            flightsCount = dto.flightsCount,
            flights = dto.flights?.map { flightDto ->
                mapFlightDtoToEntity(flightDto)
            },
            profileImageUrl = dto.profileImageUrl,
            profileImageThumbnailUrl = dto.profileImageThumbnailUrl
        )
    }

    fun mapAstronautEntityToDomain(entity: AstronautEntity): Astronaut {
        return Astronaut(
            id = entity.id,
            name = entity.name,
            age = entity.age,
            bio = entity.bio,
            nationality = entity.nationality,
            status = mapStatusEntityToDomain(entity.status),
            flightsCount = entity.flightsCount,
            flights = entity.flights?.map { flightEntity ->
                mapFlightEntityToDomain(flightEntity)
            },
            profileImageUrl = entity.profileImageUrl,
            profileImageThumbnailUrl = entity.profileImageThumbnailUrl
        )
    }

    private fun mapStatusDtoToEntity(dto: StatusDto): StatusEntity {
        return StatusEntity(
            id = dto.id,
            name = dto.name
        )
    }

    private fun mapStatusEntityToDomain(entity: StatusEntity): Status {
        return Status(
            id = entity.id,
            name = entity.name
        )
    }

    private fun mapFlightDtoToEntity(dto: FlightDto): FlightEntity {
        return FlightEntity(
            id = dto.id,
            name = dto.name
        )
    }

    private fun mapFlightEntityToDomain(entity: FlightEntity): Flight {
        return Flight(
            id = entity.id,
            name = entity.name
        )
    }
}
