package com.some.example.camel.spring.aop.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogEventAspect {
    private static Logger logger = LoggerFactory.getLogger(LogEventAspect.class);

    @Around("@annotation(logEvent)")
    public Object doLogEvent(ProceedingJoinPoint joinPoint, LogEvent logEvent) throws Throwable {
        Object returnValue = null;

        try {
            logger.info("Entered aspect for: " + joinPoint.getSignature().toShortString());
            returnValue = joinPoint.proceed();
            return returnValue;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
