package com.example.myapplication.databaseBoliche

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.threeten.bp.LocalTime

class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToTime(value: String): LocalTime {
        return LocalTime.parse(value)
    }

    @TypeConverter
    fun fromTimeToString(time: LocalTime): String {
        return time.toString()
    }
}