package com.gaohx.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {
    /**
     * ("execution(* com.gaohx.web.controller..*.*(..))")
     * execution():表达式的主体
     * 第一个“*”：表示任意的返回值类型
     * com.gaohx.web.controller：AOP所切的服务的包名
     * 包名后面的“..”：表示当前包及子包
     * 第二个“*”：表示所有类
     * .*(..)：表示任何方法
     */
    @Around("execution(* com.gaohx.web.controller.*.*(..))")
    public Object logAcess(ProceedingJoinPoint point) {
        System.out.println(point.getSignature().getName());
        System.out.println(point.getSignature().getDeclaringType().getName());
        try {
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
