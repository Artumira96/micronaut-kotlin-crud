package com.example.controller

import com.example.model.User
import com.example.services.UserService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import java.util.*


@Controller("/user")
class CRUD (@Inject val service: UserService) {

    @Get(value = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUser(id: Int): Optional<User>? {
        return service.getUser(id)
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun postUser(user: User): User {
        service.createUser(user)
        return user
    }

    @Patch(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    fun putUser(id: Int, user: User) {
        user.id = id
        service.updateUser(user)
    }

    @Delete(value = "/{id}")
    fun deleteUser(id: Int) {
        service.deleteUser(id)
    }


}