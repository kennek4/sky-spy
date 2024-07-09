package com.kennek.skyspy.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.kennek.skyspy.data.repositories.WeatherRepository

class WeatherViewModel(
    private val repository: WeatherRepository
): ViewModel() {

}