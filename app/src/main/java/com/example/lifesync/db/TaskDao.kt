package com.example.lifesync.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM Task_table")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Task_table WHERE Task_name LIKE :name")
    fun findByName(name: String): List<Task>
}