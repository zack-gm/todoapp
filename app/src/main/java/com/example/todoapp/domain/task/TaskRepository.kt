package com.example.todoapp.domain.task

interface TaskRepository {
    suspend fun list(): List<Task>?
}