package com.kennek.skyspy.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kennek.skyspy.data.responses.Current
import com.kennek.skyspy.data.responses.CurrentUnits
import com.kennek.skyspy.data.responses.Daily
import com.kennek.skyspy.data.responses.DailyUnits
import com.kennek.skyspy.data.responses.Hourly
import com.kennek.skyspy.data.responses.HourlyUnits

@Entity
data class Forecast(
    val current: Current,
    val current_units: CurrentUnits,
    val daily: Daily,
    val daily_units: DailyUnits,
    val hourly: Hourly,
    val hourly_units: HourlyUnits,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
