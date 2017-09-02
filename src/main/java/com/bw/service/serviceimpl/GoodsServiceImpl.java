package com.bw.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.bw.dao.GoodsDao;
import com.bw.pojo.Goods;
import com.bw.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 12:42 2017/8/31
 */
@Service
@Transactional
public class GoodsServiceImpl implements IGoodsService{
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private JedisPool jedisPool;


    //查询所有商品

    @Override
    public List<Goods> getAllGoods()
    {
        List<Goods> list=null;
        Jedis jedis= jedisPool.getResource();
        String list1=jedis.get("goodList");
        if(list1==null){
           List<Goods> list2= goodsDao.getAllGoods();
           String str=JSON.toJSONString(list2);
           jedis.set("goodList",str);
        }else{
            list = (List<Goods>) JSON.parse(list1);
        }
        return list;
    }

    @Override
    public List<Goods> getGoodsByIds(String ids) {
        return goodsDao.getGoodsByIds(ids);
    }

    //加
    @Override
    public String addAccount(Integer id) {
        Goods goods = goodsDao.getGoodsById(id);
        int account = goods.getAccount();
        account+=1;
        goods.setAccount(account);
        goodsDao.updateAccount(goods);
        return "true";
    }

    //减
    @Override
    public String reduceAccount(Integer id) {
        Goods goods = goodsDao.getGoodsById(id);
        int account = goods.getAccount();
        account-=1;
        goods.setAccount(account);
        goodsDao.updateAccount(goods);
        return "true";
    }

    //删除
    @Override
    public void deleteById(Integer id) {
        goodsDao.deleteById(id);
    }


}
