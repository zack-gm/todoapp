package com.example.todoapp.data

import com.example.domain.user.User

interface UserDataSource {

    suspend fun get(id: String): User?

    suspend fun list(): List<User>?

    fun add(user: User)

    suspend fun addAll(users: List<User>)

    fun delete(user: User)
}