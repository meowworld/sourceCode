package com.example.anno.log.web;

import com.example.anno.log.anno.ThirdLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAnnoController {

    @ThirdLog(local = "localApplication",third = "test")
    @GetMapping("/annoLog")
    public void annoLog(){
        System.out.println("日志注解测试");
        TestService testService = new TestService();
        testService.test("哈哈哈");
    }
}
