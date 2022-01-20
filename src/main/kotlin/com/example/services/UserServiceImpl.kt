package com.example.services

import com.example.model.User
import jakarta.inject.Singleton
import kotlin.random.Random

@Singleton
class UserServiceImpl : UserService {
    var userMap: MutableMap<Int, User> = hashMapOf()

    override fun getUser(id: Int): User? {
        return userMap.get(id)
    }

    override fun createUser(user: User) {
        user.id = Random.nextInt()
        userMap.put(user.id, user)
    }

    override fun updateUser(user: User) {
        var current = userMap.get(user.id)
        current?.update(user)
    }

    override fun deleteUser(id: Int) {
        userMap.remove(id)
    }

    override fun User.update(newUser: User) {
        if (newUser.name != null) {
            this.name = newUser.name
        }
        if (newUser.lastName != null) {
            this.lastName = newUser.lastName
        }
        if (newUser.age != null) {
            this.age = newUser.age
        }
    }
}
