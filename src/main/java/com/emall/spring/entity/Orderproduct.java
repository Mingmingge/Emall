package com.emall.spring.entity;

public class Orderproduct {
    private String uuid;

    private String orderid;

    private String productid;

    private Integer count;

    private Long countprice;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getCountprice() {
        return countprice;
    }

    public void setCountprice(Long countprice) {
        this.countprice = countprice;
    }
}