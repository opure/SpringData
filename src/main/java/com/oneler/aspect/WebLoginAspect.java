package com.oneler.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Web cas 登陆Session灯状态切面拦截
 *
 * @version 1.0.0
 */
@Aspect
@Order(5)
@Component
public class WebLoginAspect {

    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.oneler.web..*.*(..))")
    public void casLogin() {
    } //只是一个标记，方法体不会被执行，类似于spring2.x配置文件里面的<aop:pointcut id="beforePointCut" ...> 具体逻辑在befor after,around里写


    @Before("casLogin()")
    public void doBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterThrowing(value = "casLogin()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable  ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }

    @AfterReturning(value = "casLogin()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after return ing The method " + methodName + " return with " + result);
    }


    @Around("casLogin()")
    public Object aroundMethod(ProceedingJoinPoint pjd) throws Throwable {
        Object result = null;
        String methodName = pjd.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            long start = System.currentTimeMillis();
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            result = pjd.proceed();
            System.out.println("SPEND　Time" + (System.currentTimeMillis() - start));
            //返回通知
            System.out.println("The method " + methodName + " ends with " + Arrays.asList(pjd.getArgs()));
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs expection : " + e);
            throw e;
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");
        return result;
    }

}




