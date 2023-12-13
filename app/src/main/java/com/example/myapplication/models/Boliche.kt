package com.example.myapplication.models

import org.threeten.bp.LocalTime

data class Boliche(
    val title: String,
    val description: String,
    val rating: Int,
    val location: String,
    val timeOpen: LocalTime,
    val timeClose: LocalTime,
    val celNumber: String,
    val linkWebsite: String,
    val opinions: List<String>,
)
