package com.emall.spring.entity;

import java.util.Date;

public class Customer {
    private String customerid;

    private String customername;

    private String nickname;

    private String customerpassword;

    private String tel;

    private String addr;

    private Date registiontime;

    private Long blance;

    private String credit;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCustomerpassword() {
        return customerpassword;
    }

    public void setCustomerpassword(String customerpassword) {
        this.customerpassword = customerpassword;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getRegistiontime() {
        return registiontime;
    }

    public void setRegistiontime(Date registiontime) {
        this.registiontime = registiontime;
    }

    public Long getBlance() {
        return blance;
    }

    public void setBlance(Long blance) {
        this.blance = blance;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}