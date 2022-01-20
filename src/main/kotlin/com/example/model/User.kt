package com.example.model

import javax.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0;

    @Column(name = "name", nullable = true, unique = false)
    var name: String? = null

    @Column(name = "lastname", nullable = true, unique = false)
    var lastname: String? = null

    @Column(name = "age", nullable = true, unique = false)
    var age: Int? = 0

}