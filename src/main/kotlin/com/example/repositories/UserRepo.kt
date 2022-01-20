package com.example.repositories

import com.example.model.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepo  : CrudRepository<User, Int> {

}