package com.example.todoapp.data.repository.remote.user

import com.example.domain.user.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRemote {

    @GET("users/{id}")
    fun get(@Path("id") id: String): Call<User>

    @GET("users")
    fun list(): Call<List<User>>
}