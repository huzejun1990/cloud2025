package com.dream.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-10-17 14:41
 **/
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-----------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "---------------testB";
    }

}
