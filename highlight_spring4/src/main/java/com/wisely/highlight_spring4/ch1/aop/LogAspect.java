package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect //1
@Component //2
public class LogAspect {

    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)") //3
    public void annotationPointCut() {
    }

    /**
     * After 的效果是在方法执行完毕后执行
     *
     * @param joinPoint
     */
    @After("annotationPointCut()") //4
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("after上获取action注解的值-->" + action.name()); //5
    }

    /**
     * Before实在方法执行前被执行
     *
     * @param joinPoint
     */
    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("before上获取方法的名字-->" + method.getName());

    }


}
