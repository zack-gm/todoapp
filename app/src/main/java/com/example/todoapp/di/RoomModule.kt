package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.repository.room.RoomBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomBase(application: Application): RoomBase {
        return  Room.databaseBuilder(application, RoomBase::class.java, "base.db").build()
    }
}