package com.dream.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @Author huzejun
 * @Date 2025-10-19 12:44
 **/
@Component
public class MyRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getParameter("serverName");
    }
}
