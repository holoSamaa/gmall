package com.luka.gmall.service;



import com.luka.gmall.bean.UserAddress;
import com.luka.gmall.bean.UserInfo;

import java.util.List;

/**
 * 用户信息Service
 *
 * @author horo
 */
public interface UserInfoService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserInfo> getUserInfoListAll();

    /**
     * 添加用户
     *
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 更新用户
     *
     * @param userInfo
     */
    void updateUser(UserInfo userInfo);

    /**
     * 根据用户名更新用户
     *
     * @param name
     * @param userInfo
     */
    void updateUserByName(String name, UserInfo userInfo);

    /**
     * 删除用户
     *
     * @param userInfo
     */
    void delUser(UserInfo userInfo);

    /**
     * 查询用户地址
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList(String userId);
}
