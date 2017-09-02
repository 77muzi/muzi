package com.bw.controller;

import com.bw.pojo.Goods;
import com.bw.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 12:45 2017/8/31
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    //查询所有商品
    @RequestMapping(value = "queryAllGoods")
    @ResponseBody
    public List<Goods> queryAllGoods(Model model){
        List<Goods> goods = goodsService.getAllGoods();
        return goods;
    }

    //加数量
    @RequestMapping(value = "addAccount",method = RequestMethod.POST)
    public String addAccount(Integer id){
        String s = goodsService.addAccount(id);
        return "redirect:/goods/queryAllGoods.action";
    }

    //减数量
    @RequestMapping(value = "reduceAccount",method = RequestMethod.POST)
    public String reduceAccount(Integer id){
        String s = goodsService.reduceAccount(id);
        return "redirect:/goods/queryAllGoods.action";
    }

    //删除
    @RequestMapping("deleteGoods")
    public String deleteGoods(Integer id){
        goodsService.deleteById(id);
        return "redirect:/goods/queryAllGoods.action";
    }
}
