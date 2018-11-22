package com.emall.spring.entity;

public class Product {
    private String productid;

    private String productname;

    private Long price;

    private String class;

    private String imagedir;

    private String info;

    private Integer status;

    private Integer nums;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getClass() {
        return class;
    }

    public void setClass(String class) {
        this.class = class;
    }

    public String getImagedir() {
        return imagedir;
    }

    public void setImagedir(String imagedir) {
        this.imagedir = imagedir;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}