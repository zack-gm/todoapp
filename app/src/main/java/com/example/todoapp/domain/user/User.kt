package com.example.domain.user

import com.example.todoapp.domain.user.Address
import com.example.todoapp.domain.user.Company
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    var avatar: String,

    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("address")
    var address: Address,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("website")
    var website: String,

    @SerializedName("company")
    var company: Company

)