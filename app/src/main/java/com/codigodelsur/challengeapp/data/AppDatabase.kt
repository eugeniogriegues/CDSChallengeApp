package com.codigodelsur.challengeapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private const val NAME = "app-db"

        fun getInstance(context: Context) = Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                NAME,
            )
            .createFromAsset(databaseFilePath = "database/sample.db")
            .allowMainThreadQueries()
            .build()
    }
}
