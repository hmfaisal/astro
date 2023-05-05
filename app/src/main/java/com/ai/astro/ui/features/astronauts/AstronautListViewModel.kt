package com.ai.astro.ui.features.astronauts

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.astro.common.Constants.PAGE_SIZE
import com.ai.astro.data.repository.AstronautRepository
import com.ai.astro.data.remote.dto.AstronautDto
import kotlinx.coroutines.launch

class AstronautListViewModel(private val repository: AstronautRepository = AstronautRepository()) : ViewModel() {

    private val _astronautListState = mutableStateOf(listOf<AstronautDto>())
    val astronautListState: List<AstronautDto>
        get() = _astronautListState.value

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading.value

    private val _error = mutableStateOf("")
    val error: String
        get() = _error.value

    private var currentPage = 0
    private var isLastPage = false

    init {
        getAstronautList()
    }

    fun getAstronautList() {
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
