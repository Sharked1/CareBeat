package com.example.carebeat.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carebeat.data.Repository
import com.example.carebeat.data.local.BeatEntity
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var modelProducer: CartesianChartModelProducer = CartesianChartModelProducer()
        private set

    val beatData: Flow<List<BeatEntity>> = repository.getAllData()

    val beatDataState = beatData
        .stateIn(
            scope = viewModelScope,
            started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addNewData(data: Int) {
        viewModelScope.launch {
            repository.insertData(data)
        }
    }

}