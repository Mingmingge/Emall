package com.emall.spring.entity;

public class Product {
    private String productid;

    private String productname;

    private Long price;

    private String productclass;

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

    public String getProductclass() {
        return productclass;
    }

    public void setProductclass(String productclass) {
        this.productclass = productclass;
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

    @Override
    public String toString() {
        return "{" +
                "productid:'" + productid + '\'' +
                ", productname:'" + productname + '\'' +
                ", price:'" + price +'\''+
                ", productclass:'" + productclass + '\'' +
                ", imagedir:'" + imagedir + '\'' +
                ", info:'" + info + '\'' +
                ", status:'" + status + '\''+
                ", nums:'" + nums +'\''+
                '}';
    }
}