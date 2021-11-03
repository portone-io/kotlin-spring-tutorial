package com.example.demo

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class TestSingleton1 {

    fun hello() {
        println("hello from test singleton1")
    }

    @PostConstruct
    fun postConstruct() {
        println("test singleton1 is created")
        println("///////")
    }
}
