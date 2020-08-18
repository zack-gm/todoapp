package com.example.todoapp.data.repository.room.user

import androidx.room.*
import com.example.todoapp.data.repository.room.user.entity.UserEntityRoom

@Dao
interface UserDao{

    @Query("SELECT * FROM userentityroom")
    fun getAll(): List<UserEntityRoom>

    @Query("SELECT * FROM userentityroom WHERE id = :id")
    fun getById(id: String): UserEntityRoom

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(user: UserEntityRoom)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<UserEntityRoom>)

    @Update
    fun update(user: UserEntityRoom)

    @Update
    fun update(user: List<UserEntityRoom>)

    @Delete
    fun delete(user: UserEntityRoom)
}