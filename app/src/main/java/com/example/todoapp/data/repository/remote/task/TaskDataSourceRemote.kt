package com.example.todoapp.data.repository.remote.task

import com.example.todoapp.domain.task.Task
import com.example.todoapp.data.TaskDataSource
import retrofit2.*

class TaskDataSourceRemote (private var taskRemote: TaskRemote):
    TaskDataSource {

    override suspend fun list(): List<Task> {
        return taskRemote.list().await()
    }

    override fun add(task: Task) {
    }

    override fun addAll(tasks: List<Task>) {
    }

    override fun delete(task: Task) {
    }
}