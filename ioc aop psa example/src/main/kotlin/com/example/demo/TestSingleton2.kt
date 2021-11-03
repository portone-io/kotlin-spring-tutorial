package com.example.demo

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class TestSingleton2(
    private val testSingleton1: TestSingleton1
) {

    @PostConstruct
    fun postConstruct() {
        testSingleton1.hello()
        println("test singleton2 is created")
        println("///////")
    }
}