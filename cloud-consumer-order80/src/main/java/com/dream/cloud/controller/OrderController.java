package com.dream.cloud.controller;

import com.dream.cloud.entities.PayDTO;
import com.dream.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author huzejun
 * @Date 2025-09-24 16:36
 **/

@RestController
public class OrderController {

    //    public static final String PaymentSrv_URL = "/payment-order";
//    public static final String PaymentSrv_URL = "http://localhost:8001";    //先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-payment-service";     //服务注册上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }


    @GetMapping(value = "/consumer/del/{id}")
    public ResultData deletePayInfo(@PathVariable("id") Integer id) {
        return restTemplate.exchange(PaymentSrv_URL + "/pay/del/" + id, HttpMethod.DELETE, null, ResultData.class).getBody();
//        return restTemplate.postForObject(PaymentSrv_URL, payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/update")
    public ResultData updatePayInfo(@RequestBody PayDTO payDTO) {
        return restTemplate.exchange(PaymentSrv_URL + "/pay/update", HttpMethod.PUT, new HttpEntity<>(payDTO), ResultData.class).getBody();
    }



    //全部查询
    @GetMapping(value = "/consumer/pay/getAll")
    public ResultData getAllPayInfo(){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getAll", ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        System.out.println("=======================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }


}
