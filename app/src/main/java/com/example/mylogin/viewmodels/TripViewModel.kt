package com.example.mylogin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mylogin.dao.TripDao
import com.example.mylogin.database.AppDatabase
import com.example.mylogin.models.Trip
import com.example.mylogin.models.TripType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TripViewModelFactory(val db: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return TripViewModel(db.tripDao) as T;
    }
}

class TripViewModel(val tripDao: TripDao) : ViewModel() {
    private val _uiState = MutableStateFlow(Trip())
    val uiState: StateFlow<Trip> = _uiState.asStateFlow()

    private fun updateId(id: Long) {
        _uiState.update {
            it.copy(id = id)
        }
    }

    fun updateSource(newSource: String) {
        _uiState.update {
            it.copy(source = newSource)
        }
    }

    fun updateStartDate(newStartDate: String) {
        _uiState.update {
            it.copy(startDate = newStartDate)
        }
    }

    fun updateEndDate(newEndDate: String) {
        _uiState.update {
            it.copy(endDate = newEndDate)
        }
    }

    fun updateBudget(newBudget: Double) {
        _uiState.update {
            it.copy(budget = newBudget)
        }
    }

    fun updateType(newType: TripType) {
        _uiState.update {
            it.copy(type = newType)
        }
    }

    private fun new() {
        if (uiState.value.isEmpty()) return
        _uiState.update {
            it.copy(
                id = 0,
                source = "",
                startDate = "",
                endDate = "",
                budget = 0.0,
                type = TripType.LEISURE
            );
        }
    }

    fun save() {
        if (uiState.value.isEmpty()) return
        viewModelScope.launch {
            val id = tripDao.upsert(uiState.value)
            if (id > 0) {
                updateId(id)
            }
        }
    }

    fun saveNew() {
        save()
        new()
    }
}