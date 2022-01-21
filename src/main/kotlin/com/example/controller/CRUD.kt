package com.example.controller

import com.example.model.User
import com.example.services.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import java.util.*


@Controller("/user")
class CRUD (@Inject val service: UserService) {

    @Get(value = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    fun getUser(id: Int): MutableHttpResponse<Optional<User>?>? {

        var user = service.getUser(id)
        return HttpResponse.ok(user)
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun postUser(user: User): MutableHttpResponse<User>? {
        service.createUser(user)
        return HttpResponse.created(user)
    }

    @Patch(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    fun patchUser(id: Int, user: User) {
        service.updateUser(id, user)
    }

    @Delete(value = "/{id}")
    fun deleteUser(id: Int) {
        service.deleteUser(id)
    }


}