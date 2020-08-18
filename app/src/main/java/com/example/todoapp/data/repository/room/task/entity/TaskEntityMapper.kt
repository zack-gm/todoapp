package com.example.todoapp.data.repository.room.task.entity

import com.example.todoapp.domain.task.Task


class TaskEntityMapper {

    fun transform(taskEntity: TaskEntityRoom?): Task? {
        return taskEntity?.let {
                Task(
                    taskEntity.id,
                    taskEntity.status,
                    taskEntity.title,
                    taskEntity.user_id
                )
            }
    }

    fun transform(taskEntityCollection: Collection<TaskEntityRoom?>): List<Task>? {
        val taskList: MutableList<Task> = ArrayList()
        for (taskEntity in taskEntityCollection) {
            transform(taskEntity)?.let {
                taskList.add(it)
            }
        }
        return taskList
    }


    fun transform(task: Task?): TaskEntityRoom? {
        return task?.let {
            TaskEntityRoom(
                task.id,
                task.title,
                task.user_id,
                task.status
            )
        }
    }

    fun transformTo(taskCollection: Collection<Task?>): List<TaskEntityRoom>? {
        val taskList: MutableList<TaskEntityRoom> = ArrayList()
        for (taskEntity in taskCollection) {
            transform(taskEntity)?.let {
                taskList.add(it)
            }
        }
        return taskList
    }
}