package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/students")
class StudentController(
    private val studentRepository: StudentRepository
) {

    @RequestLogging
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Mono<Student> {
        return studentRepository.findById(id)
    }

    @GetMapping
    fun getAll(): Flux<Student> {
        return studentRepository.findAll()
    }

    @RequestLogging
    @PostMapping
    fun createStudent(@RequestBody student: Student): Mono<Student> {
        return studentRepository.save(student)
    }
}