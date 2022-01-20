package com.example.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/")
class Sample {

    val fibMap: MutableMap<Int, Int> = mutableMapOf(Pair(0, 0), Pair(1, 1))

    // My firs get
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String {

        return "howdy cowboy!"
    }


    // Get with path variables
    @Get(value = "/fib/{number}")
    fun fibNumber(number: Int): Int {
        return fib(number)
    }


    // Get or put on map!!!!
    fun fib(n: Int): Int =
        fibMap.getOrPut(n) {
            fibMap.getOrPut(n - 1) { fib(n - 1) } +
                    fibMap.getOrPut(n - 2) { fib(n - 2) }
        }
}