package com.example.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jianping Yu
 * @date 2021/1/8
 */
@RestController
@RequestMapping(value="/test")
public class Test {
    @GetMapping("/t")
    public String test(){
        return "hello";
    }
}
