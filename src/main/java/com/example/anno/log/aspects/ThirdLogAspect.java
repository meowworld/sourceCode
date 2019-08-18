package com.example.anno.log.aspects;

import com.alibaba.fastjson.JSON;
import com.example.anno.log.anno.ThirdLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Aspect
@Component
public class ThirdLogAspect {

    private static final Logger log = LoggerFactory.getLogger(ThirdLogAspect.class);

    // 配置织入点
    @Pointcut("@annotation(com.example.anno.log.anno.ThirdLog)")
    public void logPointCut() {}

    @Before("logPointCut()")
    public void logStart(JoinPoint joinPoint){
        ThirdLog thirdLog = getAnnotationLog(joinPoint);
        if (thirdLog == null){
            return;
        }
        String localName = thirdLog.local();
        String thirdName = thirdLog.third();
        log.info("当前微服务名称"+localName);
        log.info("要调用的第三方服务名称"+thirdName);

        String className = joinPoint.getTarget().getClass().getName();
        log.error("当前类className-->"+ className);
        String name = joinPoint.getSignature().getName();
        log.error("方法名："+name);
        Object[] args = joinPoint.getArgs();
        log.error("======方法参数列表："+ JSON.toJSONString(args));
    }


    //引入其他类切入点
    @After("logPointCut()")
    public void logEnd(JoinPoint joinPoint){
        log.error("======切面結束======");
    }

    @AfterReturning(value = "logPointCut()",returning ="result")
    public void logReture(Object result){
        log.error("======切面返回值："+JSON.toJSONString(result));
    }

    @AfterThrowing(value = "logPointCut()",throwing = "exception")
    public void logException(Exception exception){
        log.error("======切面返异常信息："+exception.getMessage());
    }

    private ThirdLog getAnnotationLog(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method!=null){
            return method.getAnnotation(ThirdLog.class);
        }
        return null;
    }

}
