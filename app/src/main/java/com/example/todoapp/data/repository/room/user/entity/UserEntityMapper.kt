package com.example.todoapp.data.repository.room.user.entity

import com.example.domain.user.User
import com.example.todoapp.domain.user.Address
import com.example.todoapp.domain.user.Company
import com.example.todoapp.domain.user.Geo


class UserEntityMapper {

    fun transform(userEntity: UserEntityRoom?): User? {
        return userEntity?.let {
                User(
                    userEntity.id,
                    userEntity.name,
                    "null",
                    userEntity.username,
                    userEntity.email,
                    Address(userEntity.street, userEntity.suite, userEntity.city, userEntity.zipcode,
                        Geo(userEntity.lat, userEntity.lng)),
                    userEntity.phone,
                    userEntity.website,
                    Company(userEntity.company_name,userEntity.catchPhrase,userEntity.bs)
                )
            }
    }

    fun transform(userEntityCollection: Collection<UserEntityRoom?>): List<User>? {
        val userList: MutableList<User> = ArrayList()
        for (userEntity in userEntityCollection) {
            transform(userEntity)?.let {
                userList.add(it)
            }
        }
        return userList
    }


    fun transform(user: User?): UserEntityRoom? {
        return user?.let {
            UserEntityRoom(
                user.id,
                user.name,
                "",
                user.username,
                user.email,
                user.address.street,
                user.address.suite,
                user.address.city,
                user.address.zipcode,
                user.address.geo.lat,
                user.address.geo.lng,
                user.phone,
                user.website,
                user.company.name,
                user.company.catchPhrase,
                user.company.bs
            )
        }
    }

    fun transformTo(userCollection: Collection<User?>): List<UserEntityRoom>? {
        val userList: MutableList<UserEntityRoom> = ArrayList()
        for (userEntity in userCollection) {
            transform(userEntity)?.let {
                userList.add(it)
            }
        }
        return userList
    }
}