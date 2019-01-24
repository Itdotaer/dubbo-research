package com.itdotaer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * MethoAspect
 *
 * @author jt_hu
 * @date 2019-01-21
 */
@Aspect
public class MethodAspect {

    @Pointcut("@annotation(com.itdotaer.aop.Method))")
    public void method() {

    }

    @Around("method()")
    public Object intoMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("intoMethod");

        return joinPoint.proceed();
    }

}
