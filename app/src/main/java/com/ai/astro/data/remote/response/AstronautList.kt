package com.ai.astro.data.remote.response

data class AstronautList(
    val count: Int,
    val results: List<Astronaut>,
    val next: String?,
    val previous: String?
)