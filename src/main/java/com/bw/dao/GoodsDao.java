package com.bw.dao;

import com.bw.pojo.Goods;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 12:40 2017/8/31
 */
public interface GoodsDao {
    //查询所有商品
    public List<Goods> getAllGoods();

    //根据ids查询所有商品
    public List<Goods> getGoodsByIds(String ids);

    //根据id查询商品
    public Goods getGoodsById(Integer id);

    //修改商品数量
    public void updateAccount(Goods goods);

    //根据id删除
    public void deleteById(Integer id);


}
