package com.example.services

import com.example.model.User
import kotlin.random.Random
import io.micronaut.http.annotation.S
@Service
class UserService {
    var userMap: MutableMap<Int, User> = hashMapOf()

    fun getUser(id: Int): User? {
        return userMap.get(id)
    }

    fun createUser(user: User) {
        user.id = Random.nextInt()
        userMap.put(user.id, user)
    }

    fun updateUser(user: User) {
        var current = userMap.get(user.id)
        current?.update(user)
    }

    fun deleteUser(id: Int) {
        userMap.remove(id)
    }

    fun User.update(newUser: User) {
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
