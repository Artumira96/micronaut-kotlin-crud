package com.example.services

import com.example.model.User
import com.example.repositories.UserRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
class UserServiceImpl(@Inject var repo: UserRepo) : UserService {
    var userMap: MutableMap<Int, User> = hashMapOf()

    override fun getUser(id: Int): Optional<User> {
        return repo.findById(id)
    }

    override fun createUser(user: User) {
        repo.save(user)
    }

    override fun updateUser(user: User) {
        var current = userMap.get(user.id)
        current?.update(user)
    }

    override fun deleteUser(id: Int) {
        repo.deleteById(id)
    }

     fun User.update(newUser: User) {
        if (newUser.name != null) {
            this.name = newUser.name
        }
        if (newUser.lastname != null) {
            this.lastname = newUser.lastname
        }
        if (newUser.age != null) {
            this.age = newUser.age
        }
    }
    override fun getAllUsers(): MutableIterable<User> {
        return repo.findAll()
    }
}
