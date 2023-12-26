package com.example.myapplication.databaseBoliche

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.models.Boliche

@Dao
interface BolicheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBoliche(boliche: Boliche?)

    @Update
    fun updateBoliche(boliche: Boliche?)

    @Delete
    fun delete(boliche: Boliche?)

    @Query("SELECT * FROM boliches")
    fun getAll(): List<Boliche>

    @Query("SELECT * FROM boliches WHERE id = :id")
    fun getBoliche(id: Int): List<Boliche>

    @Query("SELECT * FROM boliches WHERE id = :id LIMIT 1")
    fun getBolicheById(id: Int): Boliche

}