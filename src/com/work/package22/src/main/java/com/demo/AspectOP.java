package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Component
@Aspect
public class AspectOP {

    @Around("allServiceMethods()")
    public Object execTime (ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("Метод: " + joinPoint.getSignature() + " выполнен за " + (System.currentTimeMillis() - start) + "мс");
        return joinPoint.proceed();
    }

    @Pointcut("within(com.demo.*)")
    public void allServiceMethods() {}
}
