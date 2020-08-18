package com.example.todoapp.di

import com.example.todoapp.data.repository.remote.task.TaskDataSourceRemote
import com.example.todoapp.data.repository.remote.task.TaskRemote
import com.example.todoapp.data.repository.remote.user.UserDataSourceRemote
import com.example.todoapp.data.repository.remote.user.UserRemote
import com.example.todoapp.data.repository.room.RoomBase
import com.example.todoapp.data.repository.room.task.TaskDataSourceRoom
import com.example.todoapp.data.repository.room.user.UserDataSourceRoom
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideUserDataSourceRemote(userRemote: UserRemote): UserDataSourceRemote{
        return UserDataSourceRemote(userRemote)
    }

    @Provides
    @Singleton
    fun provideUserDataSourceRoom(roomBase: RoomBase): UserDataSourceRoom{
        return UserDataSourceRoom(roomBase)
    }

    @Provides
    @Singleton
    fun provideTaskDataSourceRemote(userRemote: TaskRemote): TaskDataSourceRemote{
        return TaskDataSourceRemote(userRemote)
    }

    @Provides
    @Singleton
    fun provideTaskDataSourceRoom(roomBase: RoomBase): TaskDataSourceRoom{
        return TaskDataSourceRoom(roomBase)
    }
}
