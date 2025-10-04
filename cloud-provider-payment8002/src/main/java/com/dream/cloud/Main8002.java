package com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author huzejun
 * @Date 2025-09-30 12:16
 **/
@SpringBootApplication
@MapperScan("com.dream.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient
@RefreshScope   //动态刷新
public class Main8002 {

    public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }

}