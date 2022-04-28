package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${config.info}")
    private String port;

    @GetMapping("/demo")
    public String demo(){
        return port;
    }

}
