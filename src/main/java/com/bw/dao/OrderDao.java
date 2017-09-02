package com.bw.dao;

import com.bw.pojo.Order;
import com.bw.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 18:21 2017/8/31
 */
public interface OrderDao {
    //添加订单
    public void addOrder(Order order);

}
