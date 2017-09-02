package com.bw.controller;

import com.bw.pojo.Goods;
import com.bw.pojo.Order;
import com.bw.pojo.User;
import com.bw.service.IGoodsService;
import com.bw.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 18:25 2017/8/31
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IGoodsService goodsService;

    //添加订单
    @ResponseBody
    @RequestMapping( "addOrder")
    public String addOrder(String ids, HttpServletRequest request){
        String[] ids1 = ids.split(",");

        for(String id:ids1){
            User user=(User)request.getSession().getAttribute("user");
            List<Goods> goods= goodsService.getGoodsByIds(id);
           for(Goods goods1:goods){
               Order order = new Order();
               order.setUser(user);
               order.setGoods(goods1);
               order.setGoodsAccount(goods1.getAccount());
               orderService.addOrder(order);
           }
        }
        return "true";
    }
}
