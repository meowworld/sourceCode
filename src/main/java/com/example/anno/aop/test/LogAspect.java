package com.example.anno.aop.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

//@Aspect 表明是一个切面类

@Slf4j
@Aspect
public class LogAspect {

    /**
     * todo:JoinPoint joinPoint 要出现在方法参数上，一定不能出现在后面，一定在第一个位置
     */

    //抽取公共的表达式
    //本类引用
    @Pointcut("execution(public int com.example.anno.aop.test.TestCal.*(..))")
    public void pointCut(){}

    //本类中引用切入点
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        log.error("当前切面类className-->"+ className);
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        log.error("方法名："+name);
        Object[] args = joinPoint.getArgs();
        log.error("======切面開始参数列表："+ JSON.toJSONString(args));
    }

    //引入其他类切入点
    @After("com.example.anno.aop.test.LogAspect.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        log.error("======切面結束======");
    }

    @AfterReturning(value = "pointCut()",returning ="result")
    public void logReture(Object result){
        //todo:将返回值封装发到 Object result 中
        log.error("======切面返回值："+JSON.toJSONString(result));
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        log.error("======切面返异常信息："+exception.getMessage());
    }
}
