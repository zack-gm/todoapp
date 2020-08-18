package com.example.todoapp.data.repository.remote.user

import com.example.domain.user.User
import com.example.todoapp.data.UserDataSource
import retrofit2.await
import javax.inject.Inject

class UserDataSourceRemote @Inject constructor (var userRemote: UserRemote):
    UserDataSource {

    override suspend fun get(id: String): User? {
        return userRemote.get(id).await()
    }

    override suspend fun list(): List<User>? {
        return userRemote.list().await()
    }

    override fun add(user: User) {
    }

    override suspend fun addAll(users: List<User>) {
    }

    override fun delete(user: User) {
    }
}