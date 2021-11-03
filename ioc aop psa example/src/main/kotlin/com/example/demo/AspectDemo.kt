package com.example.demo

import org.springframework.stereotype.Component

@Component
class AspectDemo {

    @PrintStart
    fun printA() {
        println("AAAAA")
    }

    @PrintStart
    fun printB() {
        println("BBBBB")
    }

    @PrintStart
    fun printC() {
        println("BBBBB")
    }
}