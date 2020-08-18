package com.example.todoapp.data.repository.remote.task

import com.example.todoapp.domain.task.Task
import retrofit2.Call
import retrofit2.http.GET

interface TaskRemote {

    @GET("todos")
    fun list(): Call<List<Task>>
}