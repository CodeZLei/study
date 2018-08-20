package com.zl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public Map index() {
    	HashMap<String, Object> hashMap = new HashMap<>();
    	hashMap.put("userName", "张三");
    	hashMap.put("userAge", 12);
        return hashMap;
    }
}
