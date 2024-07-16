package com.kennek.skyspy.data.events

sealed interface LocationEvent {
    data object SaveLocation: LocationEvent
    data object GetLocation: LocationEvent
    data class SetLocation(val newLocation: String): LocationEvent
}