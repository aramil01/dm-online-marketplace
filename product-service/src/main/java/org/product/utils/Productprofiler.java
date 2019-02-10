package org.product.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Productprofiler {

        @Pointcut("execution (*  org.product.controllers.*.*(..))")
        public void getOneProduct() { }


        @Around("getOneProduct()")
        public Object profile(ProceedingJoinPoint pjp) throws Throwable {
                long start = System.currentTimeMillis();
                Object output = pjp.proceed();
                long elapsedTime = System.currentTimeMillis() - start;
                return output;
        }

}