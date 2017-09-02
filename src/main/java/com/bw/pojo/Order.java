package com.bw.pojo;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 16:01 2017/8/30
 */
public class Order {
    private Integer id;
    private User user;
    private Goods goods;
    private Integer goodsAccount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsAccount() {
        return goodsAccount;
    }

    public void setGoodsAccount(Integer goodsAccount) {
        this.goodsAccount = goodsAccount;
    }
}
