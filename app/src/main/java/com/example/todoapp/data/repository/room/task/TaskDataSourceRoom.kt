package com.example.todoapp.data.repository.room.task

import com.example.todoapp.domain.task.Task
import com.example.todoapp.data.TaskDataSource
import com.example.todoapp.data.repository.room.RoomBase
import com.example.todoapp.data.repository.room.task.entity.TaskEntityMapper

class TaskDataSourceRoom (var roomDatabase: RoomBase):
    TaskDataSource {

    override suspend fun list(): List<Task>? {
        return TaskEntityMapper().transform(roomDatabase.taskDataSourceRoom().getAll())
    }

    override fun add(task: Task) {
        TaskEntityMapper().transform(task)?.let { roomDatabase.taskDataSourceRoom().add(it) }
    }

    override fun addAll(tasks: List<Task>) {
        TaskEntityMapper().transformTo(tasks)?.let { roomDatabase.taskDataSourceRoom().add(it) }
    }

    override fun delete(task: Task) {
        TaskEntityMapper().transform(task)?.let { roomDatabase.taskDataSourceRoom().delete(it) }
    }
}