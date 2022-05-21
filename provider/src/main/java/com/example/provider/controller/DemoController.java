package com.example.provider.controller;

import com.example.provider.service.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${config.info}")
    private String port;

    @Autowired
    private FeignService feignService;

    @GetMapping("/demo")
    public String demo(){
        return port;
    }

    @PostMapping("demo1")
    public String demo1(){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", "1");
        map.add("name", "zk");
        return feignService.demo(map);
    }

}
