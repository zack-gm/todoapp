package com.example.todoapp.domain.task

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("id")
    var id: Int,
    @SerializedName("completed")
    var status: Boolean,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var user_id: Int
)