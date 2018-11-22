package com.emall.spring.entity;

import java.util.Date;

public class Order {
    private String orderid;

    private String sendid;

    private String reciveid;

    private String expressaddr;

    private String expresstel;

    private Long orderprice;

    private Integer state;

    private Date orderdata;

    private Date endtime;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSendid() {
        return sendid;
    }

    public void setSendid(String sendid) {
        this.sendid = sendid;
    }

    public String getReciveid() {
        return reciveid;
    }

    public void setReciveid(String reciveid) {
        this.reciveid = reciveid;
    }

    public String getExpressaddr() {
        return expressaddr;
    }

    public void setExpressaddr(String expressaddr) {
        this.expressaddr = expressaddr;
    }

    public String getExpresstel() {
        return expresstel;
    }

    public void setExpresstel(String expresstel) {
        this.expresstel = expresstel;
    }

    public Long getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Long orderprice) {
        this.orderprice = orderprice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getOrderdata() {
        return orderdata;
    }

    public void setOrderdata(Date orderdata) {
        this.orderdata = orderdata;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}