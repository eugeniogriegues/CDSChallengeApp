package com.codigodelsur.challengeapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task>

    @Insert
    fun insertAll(vararg tasks: Task)
}
