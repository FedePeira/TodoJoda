package com.example.myapplication.databaseBoliche

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.models.Boliche

@Database(entities = [Boliche::class], version = 5, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun BolicheDao(): BolicheDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}