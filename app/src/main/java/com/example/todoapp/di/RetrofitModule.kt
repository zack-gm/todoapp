package com.example.todoapp.di

import com.example.todoapp.data.repository.remote.task.TaskRemote
import com.example.todoapp.data.repository.remote.user.UserRemote
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
     fun provideUserRemote(retrofit: Retrofit): UserRemote{
         return retrofit.create(UserRemote::class.java)
     }

    @Provides
     fun provideTaskRemote(retrofit: Retrofit): TaskRemote{
         return retrofit.create(TaskRemote::class.java)
     }

    @Provides
    fun provideRetrofit(): Retrofit{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient? {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

}