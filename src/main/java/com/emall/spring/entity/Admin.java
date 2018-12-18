package com.emall.spring.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Admin {
    private String adminid;

    private String adminname;

    private String adminnickname;

    private Integer sex;

    private Integer age;

    private Date registtime;

    private BigDecimal balance;

    private String admintel;

    private String adminemail;

    private String admininfo;

    private String adminpwd;

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminnickname() {
        return adminnickname;
    }

    public void setAdminnickname(String adminnickname) {
        this.adminnickname = adminnickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAdmintel() {
        return admintel;
    }

    public void setAdmintel(String admintel) {
        this.admintel = admintel;
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail;
    }

    public String getAdmininfo() {
        return admininfo;
    }

    public void setAdmininfo(String admininfo) {
        this.admininfo = admininfo;
    }
}