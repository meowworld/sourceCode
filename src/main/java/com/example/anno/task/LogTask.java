package com.example.anno.task;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 代码埋点类
 */

@Data
public class LogTask implements Runnable {

    private LogInfo logInfo;

    @Override
    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(logInfo),headers);

        String url = "http://localhost:8081/log/save";
        ResponseEntity<Map> responseMap = restTemplate.postForEntity(url, httpEntity,Map.class);
    }

}
