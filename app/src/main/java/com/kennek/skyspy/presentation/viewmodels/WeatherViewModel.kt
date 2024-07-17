package com.kennek.skyspy.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kennek.skyspy.data.datastore.DataStoreRepository
import com.kennek.skyspy.data.events.LocationEvent
import com.kennek.skyspy.data.repositories.WeatherRepository
import com.kennek.skyspy.data.room.entities.CurrentWeather
import com.kennek.skyspy.data.room.entities.DateForecast
import com.kennek.skyspy.data.states.LocationState
import com.kennek.skyspy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val dataStoreRepository: DataStoreRepository,
): ViewModel() {

    // States
    private val _locationState: MutableStateFlow<LocationState> = MutableStateFlow(LocationState())
    val locationState: StateFlow<LocationState> = _locationState.asStateFlow()

    private val _currentWeather: MutableStateFlow<List<CurrentWeather>> = MutableStateFlow(emptyList())
    val currentWeather: StateFlow<List<CurrentWeather>> = _currentWeather.asStateFlow()

    private val _forecast: MutableStateFlow<List<DateForecast>> = MutableStateFlow(emptyList())
    val forecast: StateFlow<List<DateForecast>> = _forecast.asStateFlow()

    init {
        onLocationEvent(LocationEvent.GetLocation)
    }

    fun onLocationEvent(event: LocationEvent) {
        when (event) {
            LocationEvent.GetLocation -> {
                viewModelScope.launch {
                    _locationState.update {
                        it.copy(
                            locationName = dataStoreRepository.getLocationName(),
                            latitude = dataStoreRepository.getLatitude(),
                            longitude = dataStoreRepository.getLongitude()
                        )
                    }
                }
            }

            is LocationEvent.SetLocation -> {
                viewModelScope.launch {
                    val response: Resource<Pair<Double, Double>> = dataStoreRepository
                        .isLocationNameValid(event.newLocation)

                    if (response.data != null) {
                        val (latitude: Double, longitude: Double) = response.data

                        _locationState.update {
                            it.copy(
                                locationName = event.newLocation,
                                latitude = latitude,
                                longitude = longitude
                            )
                        }

                        dataStoreRepository.updateCoordinates(latitude = latitude, longitude = longitude)
                        dataStoreRepository.updateLocationName(_locationState.value.locationName)
                    } else {
                        TODO("Show error message, input name was invalid")
                    }
                }
            }
        }
    }
}