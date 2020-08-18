package com.example.todoapp.domain.user

import com.example.domain.user.User

interface UserRepository {

    suspend fun get(id: String): User?

    suspend fun list(): List<User>?

    fun add(user: User)

    fun delete(user: User)

}