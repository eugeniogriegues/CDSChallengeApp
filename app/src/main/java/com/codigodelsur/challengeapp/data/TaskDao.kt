package com.codigodelsur.challengeapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task>

    @Query("SELECT description FROM tasks")
    fun getDescriptions(): List<String>

    @Insert
    fun insertAll(vararg tasks: Task)

    @Delete
    fun deleteTask (task: Task)
}
