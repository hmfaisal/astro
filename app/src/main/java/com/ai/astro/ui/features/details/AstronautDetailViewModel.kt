package com.ai.astro.ui.features.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.astro.data.repository.AstronautRepository
import com.ai.astro.model.astronaut.Astronaut
import kotlinx.coroutines.launch

class AstronautDetailViewModel(
    private val repository: AstronautRepository = AstronautRepository()
): ViewModel() {

    private val _astronautDetailsState = mutableStateOf<Astronaut?>(null)
    val astronautDetailState: State<Astronaut?>
        get() = _astronautDetailsState

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading.value

    private val _error = mutableStateOf("")
    val error: String
        get() = _error.value

    // Function to get an astronaut by ID
    fun getAstronautDetails(astronautId: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val astronaut = repository.getAstronautById(astronautId)
                _astronautDetailsState.value = astronaut
            } catch (e: Exception) {
                _error.value = "Error retrieving astronaut details: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}