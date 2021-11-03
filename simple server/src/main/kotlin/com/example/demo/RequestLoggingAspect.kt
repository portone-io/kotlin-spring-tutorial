package com.example.demo

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
@Aspect
class RequestLoggingAspect {

    private val logger = LoggerFactory.getLogger("logger")

    @Around("@annotation(RequestLogging)")
    fun requestLogging(joinPoint: ProceedingJoinPoint): Any? {
        val argsStr = joinPoint.args.joinToString { it.toString() }

        logger.info("Request $argsStr")

        return joinPoint.proceed()
    }
}