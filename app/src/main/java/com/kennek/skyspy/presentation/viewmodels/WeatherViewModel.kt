package com.kennek.skyspy.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.kennek.skyspy.data.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

}