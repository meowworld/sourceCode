package com.example.anno.anno.main6;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ColorController {

    @Resource
    private ColorService colorService;

    @Override
    public String toString() {
        return "ColorController{" +
                "colorService=" + colorService +
                '}';
    }
}
