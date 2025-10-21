package com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author huzejun
 * @Date 2025-10-20 21:09
 **/
@SpringBootApplication
@MapperScan("com.dream.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient  //服务注册与发瑞
@EnableFeignClients
public class SeataStorageMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2002.class, args);
    }
}