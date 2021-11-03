package com.example.demo

import org.springframework.data.annotation.Id

data class Student(
    @Id val id: Long? = null,
    val firstname: String,
    val lastname: String
)