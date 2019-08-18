package com.example.anno.task;


import com.alibaba.fastjson.JSON;
import com.example.anno.anno.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TestController {


    @GetMapping("/log")
    public String logSave2Base(){

        Person person = new Person();
        person.setName("meow");
        person.setAge(18);

        Person person2 = new Person();
        person2.setName("meow");
        person2.setAge(18);

        LogUtil.saveLog(JSON.toJSONString(person), JSON.toJSONString(person2));

        return "ok";
    }


}
