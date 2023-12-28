package com.example.myapplication.models

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myapplication.databaseBoliche.Converters
import org.threeten.bp.LocalTime

@Entity(tableName = "boliches")
@TypeConverters(Converters::class)
class Boliche(
    id: Int? = null,
    title: String,
    description: String,
    rating: Int,
    location: String,
    timeOpen: LocalTime,
    timeClose: LocalTime,
    celNumber: String,
    linkWebsite: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?

    @ColumnInfo(name = "title")
    var title: String

    @ColumnInfo(name = "description")
    var description: String

    @ColumnInfo(name = "stats")
    var stats: MutableList<String>

    @ColumnInfo(name = "rating")
    var rating: Int

    @ColumnInfo(name = "location")
    var location: String

    @ColumnInfo(name = "timeOpen")
    var timeOpen: LocalTime

    @ColumnInfo(name = "timeClose")
    var timeClose: LocalTime

    @ColumnInfo(name = "celNumber")
    var celNumber: String

    @ColumnInfo(name = "linkWebsite")
    var linkWebsite: String

    @ColumnInfo(name = "opinions")
    var opinions: MutableList<String>

    @ColumnInfo(name = "images")
    var images: MutableList<String>


    init {
        this.id = id
        this.title = title
        this.description = description
        this.stats = mutableListOf<String>()
        this.rating = rating
        this.location = location
        this.timeOpen = timeOpen
        this.timeClose = timeClose
        this.celNumber = celNumber
        this.linkWebsite = linkWebsite
        this.opinions = mutableListOf<String>()
        this.images = mutableListOf<String>()
    }
}
