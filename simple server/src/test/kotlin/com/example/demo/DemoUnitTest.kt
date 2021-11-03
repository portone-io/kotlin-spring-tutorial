package com.example.demo

import io.mockk.CapturingSlot
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono

class DemoUnitTest {

    val studentRepository: StudentRepository = mockk()
    val studentController = StudentController(studentRepository)

    @Test
    fun getTest() {
        // given
        val givenStudentId = 1L
        val slot: CapturingSlot<Long> = slot()

        every {
            studentRepository.findById(capture(slot))
        } answers {
            Mono.just(
                Student(
                    id = slot.captured,
                    firstname = "firstname",
                    lastname = "lastname"
                )
            )
        }

        // when
        val response = studentController.getById(givenStudentId).block()!!

        // then
        assertEquals(givenStudentId, response.id)
    }
}