package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("")
    public String landPage(){
        return "the sever is running ";
    }

    @GetMapping("hello")
    public  String hello(){
        return "hello world";
    }


}
