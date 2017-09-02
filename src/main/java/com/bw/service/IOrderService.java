package com.bw.service;

import com.bw.pojo.Order;
import com.bw.pojo.User;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 18:23 2017/8/31
 */
public interface IOrderService {
    //添加订单
    public String addOrder(Order order);
}
