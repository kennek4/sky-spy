package com.kennek.skyspy.data.room.entities

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.kennek.skyspy.data.room.custom.HourlyDoubleList
import com.kennek.skyspy.data.room.custom.HourlyStringList
import javax.inject.Inject

@ProvidedTypeConverter
class Converters @Inject constructor(
    private val gson: Gson
) {

    // Double List Decode
    @TypeConverter
    fun encodeDoubleList(value: HourlyDoubleList): String = gson.toJson(value)

    @TypeConverter
    fun decodeDoubleList(value: String): HourlyDoubleList = gson.fromJson(value, HourlyDoubleList::class.java)

    // String List Decode
    @TypeConverter
    fun decodeStringList(value: HourlyStringList): String = gson.toJson(value)

    @TypeConverter
    fun decodeStringList(value: String): HourlyStringList = gson.fromJson(value, HourlyStringList::class.java)
}