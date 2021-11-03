package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.test.StepVerifier

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests(
    @LocalServerPort private val port: Int
){

    @Test
    fun contextLoads() {
    }

    @Test
    fun createStudent() {
        // given
        val client = WebClient.create("http://localhost:${port}")
        val givenStudent = Student(
            firstname = "firstname_demo",
            lastname = "lastname_demo"
        )

        // when
        val response: Student = client
            .post()
            .uri("students")
            .bodyValue(givenStudent)
            .retrieve()                 // client message 전송
            .bodyToMono(Student::class.java)  // body type : EmpInfo
            .block()!!

        // then
        assertEquals(givenStudent.firstname, response.firstname)
        assertEquals(givenStudent.lastname, response.lastname)
    }
}
