package org.product.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.Arrays;


@Aspect
@Component
public class RouteLogAspect {
    @Around(value = "hasRequestMapping() && all()")
    
    public Object logEntryRest(ProceedingJoinPoint jp) throws Throwable {
    	
        final MethodSignature signature = (MethodSignature) jp.getSignature();
        final Method method = signature.getMethod();
        final RequestMapping controllerAnnotation = method.getAnnotation(RequestMapping.class);
        final String controllerRestPath = (controllerAnnotation.value().length == 0) ? "" : controllerAnnotation.value()[0];

        final RequestMapping controllerMethodAnnotation = method.getAnnotation(RequestMapping.class);
        final RequestMethod controllerRestMethod = (controllerMethodAnnotation.method().length == 0) ? RequestMethod.GET : controllerMethodAnnotation.method()[0];
        String className = jp.getSignature().getDeclaringType().getSimpleName();
        long start = System.currentTimeMillis();
        Object output = jp.proceed();
        long timeExec = System.currentTimeMillis() - start;
        String logMessage ="[{}][{}[{}][{}][{}] : {}"+timeExec+controllerRestMethod.toString()+ controllerRestPath+
                className+
                method.getName()+
                Arrays.toString(jp.getArgs());
        
        java.util.logging.Logger.getLogger("Controller").info(logMessage);
        return output;
    }
    @Pointcut("execution(* *(..))")
    public void all() {

    }
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void hasRequestMapping(){

    }
}
