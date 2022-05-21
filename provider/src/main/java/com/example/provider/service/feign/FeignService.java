package com.example.provider.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "demo", url = "localhost:8081")
public interface FeignService {

    // 不能加consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    @PostMapping(value = "/test/dd")
    String demo(MultiValueMap<String, String> map);

}
