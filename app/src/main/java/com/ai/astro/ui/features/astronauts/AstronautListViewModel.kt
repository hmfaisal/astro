package com.ai.astro.ui.features.astronauts

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.astro.common.Constants.PAGE_SIZE
import com.ai.astro.data.repository.AstronautRepository
import com.ai.astro.data.remote.dto.AstronautDto
import kotlinx.coroutines.launch

class AstronautListViewModel(
    private val repository: AstronautRepository = AstronautRepository()
) : ViewModel() {

    private val _astronautListState = mutableStateOf(listOf<AstronautDto>())
    val astronautListState: List<AstronautDto>
        get() = _astronautListState.value

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading.value

    private val _error = mutableStateOf("")
    val error: String
        get() = _error.value

    private var currentPage: Int = 0
    private var isLastPage: Boolean = false

    init {
        getAstronautList()
    }

    fun getAstronautList() {
        if (isLastPage) return // Don't fetch if it's the last page
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val astronauts = repository.getAstronauts(currentPage, PAGE_SIZE)
                if (astronauts.isNotEmpty()) {
                    _astronautListState.value = _astronautListState.value + astronauts
                    currentPage++
                } else {
                    isLastPage = true
                }
            } catch (e: Exception) {
                _error.value = "Error retrieving astronauts: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
