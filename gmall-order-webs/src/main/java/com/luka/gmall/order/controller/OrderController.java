package com.luka.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.luka.gmall.bean.UserAddress;
import com.luka.gmall.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单
 * @author horo
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    private UserInfoService userInfoService;

    @RequestMapping("/trade")
    public List<UserAddress> trade(@RequestParam("userId") String userId){
        return userInfoService.getUserAddressList(userId);
    }
}
