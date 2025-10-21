package com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author huzejun
 * @Date 2025-10-20 21:05
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.dream.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
public class SeataOrderMainApp2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2001.class, args);
    }
}