package com.example.todoapp.data.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.repository.room.task.TaskDao
import com.example.todoapp.data.repository.room.task.entity.TaskEntityRoom
import com.example.todoapp.data.repository.room.user.entity.UserEntityRoom
import com.example.todoapp.data.repository.room.user.UserDao

@Database(
    entities = [UserEntityRoom::class, TaskEntityRoom::class],
    version = 1,
    exportSchema = false
)
abstract class RoomBase: RoomDatabase() {

    abstract fun userDataSourceRoom(): UserDao

    abstract fun taskDataSourceRoom(): TaskDao
}