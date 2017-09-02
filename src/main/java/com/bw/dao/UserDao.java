package com.bw.dao;

import com.bw.pojo.User;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 16:06 2017/8/30
 */
public interface UserDao {
    //登录
    public User userLogin(User user);

    //注册
    public void addUser(User user);


    //验证姓名唯一
    public int checkName(String userName);
}
