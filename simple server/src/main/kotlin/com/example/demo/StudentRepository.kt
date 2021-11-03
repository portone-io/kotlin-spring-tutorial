package com.example.demo

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface StudentRepository : ReactiveCrudRepository<Student, Long>
