package com.example.todoapp.data.repository.room.task

import androidx.room.*
import com.example.todoapp.data.repository.room.task.entity.TaskEntityRoom

@Dao
interface TaskDao{

    @Query("SELECT * FROM taskEntityRoom")
    fun getAll(): List<TaskEntityRoom>

    @Query("SELECT * FROM taskEntityRoom WHERE id = :id")
    fun getById(id: String): TaskEntityRoom

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(user: TaskEntityRoom)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<TaskEntityRoom>)

    @Update
    fun update(user: TaskEntityRoom)

    @Delete
    fun delete(user: TaskEntityRoom)
}