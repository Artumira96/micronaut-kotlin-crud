package com.example.model

class User {
    var id: Int = 0;

    var name: String? = null

    var lastName: String? = null

    var age: Int? = 0

    constructor(id: Int) {
        this.id = id
    }

    override fun toString(): String {
        return "User(id= $id, name=$name, lastName=$lastName, age=$age)"
    }

}