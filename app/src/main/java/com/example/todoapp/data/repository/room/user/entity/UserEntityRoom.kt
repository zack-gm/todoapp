package com.example.todoapp.data.repository.room.user.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntityRoom(

    @PrimaryKey var id: Int,

    @ColumnInfo(name ="name")
    var name: String,

    @ColumnInfo(name ="avatar")
    var avatar: String,

    @ColumnInfo(name ="username")
    var username: String,

    @ColumnInfo(name ="email")
    var email: String,

    @ColumnInfo(name ="street")
    var street: String,

    @ColumnInfo(name ="suite")
    var suite: String,

    @ColumnInfo(name ="city")
    var city: String,

    @ColumnInfo(name ="zipcode")
    var zipcode: String,

    @ColumnInfo(name ="lat")
    var lat: String,

    @ColumnInfo(name ="lng")
    var lng: String,

    @ColumnInfo(name ="phone")
    var phone: String,

    @ColumnInfo(name ="website")
    var website: String,

    @ColumnInfo(name ="company_name")
    var company_name: String,

    @ColumnInfo(name ="catchPhrase")
    var catchPhrase: String,

    @ColumnInfo(name ="bs")
    var bs: String

)