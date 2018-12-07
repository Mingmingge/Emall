package com.emall.spring.utils;

import com.emall.spring.entity.Product;

import java.util.ArrayList;

public class ProductCat {

    String type;

    ArrayList<Product> list;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }
}
