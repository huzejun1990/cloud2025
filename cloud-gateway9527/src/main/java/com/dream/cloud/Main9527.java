package com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author huzejun
 * @Date 2025-10-11 9:34
 **/
@SpringBootApplication
@EnableDiscoveryClient  //服务注册与发现
public class Main9527 {
    public static void main(String[] args) {
        SpringApplication.run(Main9527.class,args);
    }
}