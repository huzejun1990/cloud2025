package com.dream.cloud.controller;

import com.dream.cloud.resp.ResultData;
import com.dream.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-10-21 17:24
 **/
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId,Integer count){

        storageService.decrease(productId,count);
        return ResultData.success("扣减库存成功！");

    }

}
