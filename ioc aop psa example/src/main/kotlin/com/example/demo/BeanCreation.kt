package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class BeanCreatedByIoCContainer {

    fun hello() {
        println("hello from Bean created by @Component")
    }
}

@Configuration
class BeanConfiguration {

    @Bean
    fun hello(): BeanCreatedByMe {
        return BeanCreatedByMe()
    }

    fun hello2() {
        println("sdfsdf")
    }
}

class BeanCreatedByMe {
    fun hello() {
        println("hello from Bean created by me")
    }
}
