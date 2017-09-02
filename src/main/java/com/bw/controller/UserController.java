package com.bw.controller;

import com.bw.pojo.User;
import com.bw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 16:11 2017/8/30
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;


    //登录
    @RequestMapping(value = "userLogin",method = RequestMethod.POST)
    public String userLogin(User user, HttpServletRequest request){
        User u = userService.userLogin(user);
        if(u==null){
            request.setAttribute("msg","用户名或密码不正确!");
            return "../index";
        }else{
            request.getSession().setAttribute("user",u);
            return "goodsList";
        }
    }


    //去注册页面
    @RequestMapping(value = "toReg",method = RequestMethod.GET)
    public String toReg(){
        return "reg";
    }

    //注册
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(User user){
        userService.addUser(user);
        return "../index";
    }

    //验证姓名
    @RequestMapping(value = "checkName",method = RequestMethod.POST)
    @ResponseBody
    public String checkName(String userName){
        String flag = userService.checkName(userName);
        return flag;
    }
}
