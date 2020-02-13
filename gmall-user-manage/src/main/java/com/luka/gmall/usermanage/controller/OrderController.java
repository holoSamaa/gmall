package com.luka.gmall.usermanage.controller;

import com.luka.gmall.bean.UserAddress;
import com.luka.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单controller
 * @author horo
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private UserInfoService userService;

    @RequestMapping("/userAddress")
    public List<UserAddress> getUserAddress(@RequestParam("userId") String userId){
        return userService.getUserAddressList(userId);
    }

}
