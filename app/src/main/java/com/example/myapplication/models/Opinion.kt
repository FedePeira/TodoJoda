package com.example.myapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myapplication.databaseBoliche.Converters

@Entity(tableName = "opinions")
@TypeConverters(Converters::class)
class Opinion(
    id: Int? = null,
    person: String,
    rating: Int,
    title: String,
    description: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?

    @ColumnInfo(name = "person")
    var person: String

    @ColumnInfo(name = "rating")
    var rating: Int

    @ColumnInfo(name = "title")
    var title: String

    @ColumnInfo(name = "description")
    var description: String

    init {
        this.id = id
        this.person = person
        this.rating = rating
        this.title = title
        this.description = description
    }
}