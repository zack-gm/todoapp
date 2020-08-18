package com.example.todoapp.di

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.todoapp.presentation.fragment.TaskFragment
import com.example.todoapp.presentation.fragment.UserFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton



@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidInjectionModule::class,
        DataModule::class,
        DataSourceModule::class,
        RetrofitModule::class,
        RoomModule::class,
        ViewModelModule::class
    ]
)
interface FragComponent{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): FragComponent
    }

    fun inject(act: UserFragment)
    fun inject(act: TaskFragment)
}