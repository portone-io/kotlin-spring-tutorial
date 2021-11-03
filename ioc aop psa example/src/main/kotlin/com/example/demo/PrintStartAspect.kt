package com.example.demo

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Component
@Aspect
class PrintStartAspect {

    @Around("@annotation(PrintStart)")
    fun printStart(joinPoint: ProceedingJoinPoint): Any? {
        println("Start")

        return joinPoint.proceed()
    }
}