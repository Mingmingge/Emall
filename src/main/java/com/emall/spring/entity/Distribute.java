package com.emall.spring.entity;

import java.util.Date;

public class Distribute {
    private String distributeid;

    private String distributename;

    private String distributetel;

    private String distributeaddr;

    private String distributepassword;

    private Integer type;

    private Long balance;

    private Integer status;

    private String credit;

    private String info;

    private Date registtime;

    public String getDistributeid() {
        return distributeid;
    }

    public void setDistributeid(String distributeid) {
        this.distributeid = distributeid;
    }

    public String getDistributename() {
        return distributename;
    }

    public void setDistributename(String distributename) {
        this.distributename = distributename;
    }

    public String getDistributetel() {
        return distributetel;
    }

    public void setDistributetel(String distributetel) {
        this.distributetel = distributetel;
    }

    public String getDistributeaddr() {
        return distributeaddr;
    }

    public void setDistributeaddr(String distributeaddr) {
        this.distributeaddr = distributeaddr;
    }

    public String getDistributepassword() {
        return distributepassword;
    }

    public void setDistributepassword(String distributepassword) {
        this.distributepassword = distributepassword;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }
}