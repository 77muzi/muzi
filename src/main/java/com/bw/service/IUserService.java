package com.bw.service;

import com.bw.pojo.User;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 16:07 2017/8/30
 */
public interface IUserService {
    //登录
    public User userLogin(User user);

    //注册
    public void addUser(User user);

    //验证姓名唯一
    public String checkName(String userName);
}
