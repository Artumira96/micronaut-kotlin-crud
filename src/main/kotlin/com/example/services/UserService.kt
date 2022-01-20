package com.example.services

import com.example.model.User
import java.util.*

interface UserService {


    fun getUser(id: Int):  Optional<User>?

    fun createUser(user: User)

    fun updateUser(user: User)

    fun deleteUser(id: Int)

    fun getAllUsers(): MutableIterable<User>
}