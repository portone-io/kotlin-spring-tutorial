package com.example.demo

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.interceptor.TransactionAspectSupport
import java.sql.SQLException
import javax.sql.DataSource


@Repository
class TransactionSample(
    private val dataSource: DataSource,
    private val studentRepository: StudentRepository,
    private val homeworkRepository: HomeworkRepository
) {

    @Transactional
    fun save(student: Student, homework: Homework) {
        studentRepository.save(student)
        homeworkRepository.save(homework)
    }
}