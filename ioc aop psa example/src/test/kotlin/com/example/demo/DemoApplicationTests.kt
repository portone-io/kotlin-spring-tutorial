package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class DemoApplicationTests(
	private val beanCreatedByIoCContainer: BeanCreatedByIoCContainer,
	private val beanCreatedByMe: BeanCreatedByMe,
	private val aspectDemo: AspectDemo
) {

	@Test
	fun `bean creation test`() {
		beanCreatedByIoCContainer.hello()
		beanCreatedByMe.hello()
	}

	@Test
	fun aspectDemoTest() {
		aspectDemo.printA()
	}
}
