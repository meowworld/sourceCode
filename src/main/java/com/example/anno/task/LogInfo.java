package com.example.anno.task;


import lombok.Data;

import java.util.Date;

@Data
public class LogInfo {

    //调用第三方的参数
    private String jsonParam;
    //第三方相应的参数
    private String jsonResponse;

    private String appName;

    private String className;

    private String method;

    private Date createDate;


    public LogInfo(String jsonParam ,String jsonResponse){
        this.jsonParam = jsonParam;
        this.jsonResponse = jsonResponse;
    }

}
