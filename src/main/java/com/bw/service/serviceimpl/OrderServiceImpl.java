package com.bw.service.serviceimpl;

import com.bw.dao.OrderDao;
import com.bw.pojo.Order;
import com.bw.pojo.User;
import com.bw.service.IOrderService;
import org.apache.commons.collections.OrderedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 18:24 2017/8/31
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public String addOrder(Order order) {
         orderDao.addOrder(order);
         return "true";
    }
}
