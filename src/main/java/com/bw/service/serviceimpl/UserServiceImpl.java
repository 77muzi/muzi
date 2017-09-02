package com.bw.service.serviceimpl;

import com.bw.dao.UserDao;
import com.bw.pojo.User;
import com.bw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 16:07 2017/8/30
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserDao userDao;


    //登录
    @Override
    public User userLogin(User user) {
        return userDao.userLogin(user);
    }

    //注册
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    //验证姓名
    @Override
    public String checkName(String userName) {
       int i= userDao.checkName(userName);
       if(i>0){

           return "true";
       }else{
           return "flase";
       }
    }
}
