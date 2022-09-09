package org.springinaction.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Audience {

    private static final Logger log = LoggerFactory.getLogger(Audience.class);

    @Pointcut("execution(* org.springinaction.aop.concert.Performance.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            log.info("silencing cell phones");
            log.info("taking seats");
            joinPoint.proceed();
            log.info("clap clap clap");
        } catch (Throwable e) {
            log.error("demanding a refund");
        }
    }

}
