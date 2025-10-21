package com.dream.cloud.controller;

import com.alibaba.nacos.api.model.v2.Result;
import com.dream.cloud.entities.Order;
import com.dream.cloud.resp.ResultData;
import com.dream.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-10-21 16:24
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public ResultData create(Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }

}
