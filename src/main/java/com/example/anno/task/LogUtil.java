package com.example.anno.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.ExecutorService;

@Component
public class LogUtil {

    private static LogUtil logUtil;

    @Autowired
    private ExecutorService logThreadPool;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public void construct(){
        logUtil = this;
        logUtil.logThreadPool = this.logThreadPool;
        logUtil.applicationName = this.applicationName;
    }


    @Nullable
    public static void saveLog(String param , String response){
        if (param == null && response == null){
            return;
        }

        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();

        LogInfo logInfo = new LogInfo(param , response);
        logInfo.setAppName(logUtil.applicationName);
        logInfo.setClassName(className);
        logInfo.setMethod(methodName);
        logInfo.setCreateDate(new Date());

        LogTask logTask = new LogTask();
        logTask.setLogInfo(logInfo);

        logUtil.logThreadPool.submit(logTask);
    }

}
