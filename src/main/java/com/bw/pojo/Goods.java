package com.bw.pojo;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 15:50 2017/8/30
 */
public class Goods {
    private int id;
    private String goodsName;
    private Double price;
    private int account;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
