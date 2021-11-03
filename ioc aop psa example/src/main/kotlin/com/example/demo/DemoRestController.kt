package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demo")
class RestController(
) {
    @GetMapping
    fun get(): String {
        return "hello"
    }
}
