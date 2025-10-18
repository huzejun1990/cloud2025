package com.dream.cloud.controller;

import com.dream.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @GetMapping("/testA1")
    public String testA1() {
        return "-----------------testA1";
    }


    @GetMapping("/testB")
    public String testB() {
        return "---------------testB";
    }

    @GetMapping("/testB1")
    public String testB1() {
        return "---------------testB1";
    }

    /**
     * 流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     */
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testC")
    public String testC() {
        flowLimitService.common();
        return "-----------------testC";
    }


    @GetMapping("/testD")
    public String testD() {
        flowLimitService.common();
        return "---------------testD";
    }

    /**
     * 流控效果----排队等待
     * @return
     */
    @GetMapping("/testE")
    public String testE() {
        System.out.println(System.currentTimeMillis() + "      testE,流控效果----排队等待");
        return "---------------testE";
    }

    /**
     * 新增熔断规则-慢调用比例
     * @return
     */
    @GetMapping("/testF")
    public String testF() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + "----测试：新增熔断规则-慢调用比例 ");
        return "---------------testF 新增熔断规则-慢调用比例 ";
    }



}
