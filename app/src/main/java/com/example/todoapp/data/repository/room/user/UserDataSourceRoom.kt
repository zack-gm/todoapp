package com.example.todoapp.data.repository.room.user

import com.example.domain.user.User
import com.example.todoapp.data.repository.room.user.entity.UserEntityMapper
import com.example.todoapp.data.UserDataSource
import com.example.todoapp.data.repository.room.RoomBase
import javax.inject.Inject

class UserDataSourceRoom @Inject constructor (var roomDatabase: RoomBase):
    UserDataSource {

    override suspend fun get(id: String): User? {
        return UserEntityMapper().transform(roomDatabase.userDataSourceRoom().getById(id))
    }

    override suspend fun list(): List<User>? {
        return UserEntityMapper().transform(
            roomDatabase.userDataSourceRoom().getAll())
    }

    override fun add(user: User) {
        UserEntityMapper().transform(user)?.let { roomDatabase.userDataSourceRoom().add(it) }
    }

    override suspend fun addAll(users: List<User>) {
        UserEntityMapper().transformTo(users)?.let {
            roomDatabase.userDataSourceRoom().add(it) }
    }

    override fun delete(user: User) {
        UserEntityMapper().transform(user)?.let { roomDatabase.userDataSourceRoom().delete(it) }
    }
}