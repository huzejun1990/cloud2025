package com.dream.cloud.controller;

import com.dream.cloud.entities.Pay;
import com.dream.cloud.entities.PayDTO;
import com.dream.cloud.resp.ResultData;
import com.dream.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author huzejun
 * @Date 2025-09-21 22:16
 **/
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    
    @Resource
    private PayService payService;
    
    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public String addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值：" + i;
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public String updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();

        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);

        return "成功修改记录，返回值：" + i;
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID流水",description = "查询支付流水方法")
    public Pay getById(@PathVariable("id") Integer id) {
        return payService.getById(id);
    }

    //全部查询
    @GetMapping(value = "/pay/getAll")
    public ResultData<List<Pay>> getAll(){
        List<Pay> pays = payService.getAll();
        return ResultData.success(pays);
    }
    
}
