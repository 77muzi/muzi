package com.bw.service;

import com.bw.pojo.Goods;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 12:41 2017/8/31
 */
public interface IGoodsService {
    //查询所有商品
    public List<Goods> getAllGoods();

    //根据ids查询所有商品
    public List<Goods> getGoodsByIds(String ids);

    //加数量
    public String addAccount(Integer id);

    //减数量
    public String reduceAccount(Integer id);

    //根据id删除
    public void deleteById(Integer id);



}
