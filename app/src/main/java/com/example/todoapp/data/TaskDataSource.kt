package com.example.todoapp.data

import com.example.todoapp.domain.task.Task

interface TaskDataSource {

    suspend fun list(): List<Task>?

    fun add(task: Task)

    fun addAll(tasks: List<Task>)

    fun delete(task: Task)
}