package com.example.myapplication.databaseBoliche

import androidx.room.TypeConverter
import com.example.myapplication.models.Opinion
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

    @TypeConverter
    fun fromOpinionList(list: List<Opinion>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Opinion>>() {}.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toOpinionList(data: String): List<Opinion> {
        val gson = Gson()
        val type = object : TypeToken<List<Opinion>>() {}.type
        return gson.fromJson(data, type)
    }

}