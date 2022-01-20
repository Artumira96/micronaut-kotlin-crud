package com.example.controller

import com.example.model.User
import com.example.services.UserService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*


@Controller("/user")
class CRUD {

    var service: UserService = UserService()

    @Get(value = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUser(id: Int): User? {
        var user:User?= service.getUser(id)
        printList()
        return user
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun postUser(user: User) :User {
        service.createUser(user)
        printList()
        return user
    }

    @Put(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    fun putUser(id: Int, user: User) {
        user.id = id
        service.updateUser(user)
        printList()
    }

    @Delete(value = "/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    fun deleteUser(id: Int): String {
        printList()
        return "deleted {\"userId\":\"$id\"}"
    }

    fun printList() {
        println(service.userMap)
    }
}