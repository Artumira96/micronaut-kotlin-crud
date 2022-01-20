package com.example.services

import com.example.model.User

interface UserService {
    fun getUser(id: Int): User?

    fun createUser(user: User)

    fun updateUser(user: User)

    fun deleteUser(id: Int)

    fun User.update(newUser: User) {
    }
}