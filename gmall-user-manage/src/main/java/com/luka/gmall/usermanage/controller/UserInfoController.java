package com.luka.gmall.usermanage.controller;

import com.luka.gmall.bean.UserInfo;
import com.luka.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author horo
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userService;

    @RequestMapping("/findAll")
    public List<UserInfo> findAll() {
        return userService.getUserInfoListAll();
    }

    @RequestMapping("/add")
    public void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("123@qq.com");
        userInfo.setHeadImg("img.a");
        userInfo.setLoginName("asdf");
        userInfo.setPasswd("asdfsdf");
        userInfo.setNickName("lllll");
        userService.addUser(userInfo);
    }
}

