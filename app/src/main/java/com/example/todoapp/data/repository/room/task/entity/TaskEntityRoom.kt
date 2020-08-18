package com.example.todoapp.data.repository.room.task.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntityRoom(

    @PrimaryKey var id: Int,

    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "user_id")
    var user_id: Int,
    @ColumnInfo(name ="status")
    var status: Boolean
)