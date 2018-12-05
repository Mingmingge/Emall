package com.emall.spring.services;

import com.emall.spring.dao.ProdisMapper;
import com.emall.spring.dao.ProductMapper;
import com.emall.spring.entity.Prodis;
import com.emall.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Productservice implements ProductMapper{

    @Autowired
    private ProductMapper productMapper;


    @Override
    public int deleteByPrimaryKey(String productid) {
        return productMapper.deleteByPrimaryKey(productid);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(String productid) {
        return productMapper.selectByPrimaryKey(productid);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public int updateState(Product record) {
        return productMapper.updateState(record);
    }

    @Override
    public ArrayList<Product> selectByNameLike(String productname) {
        return productMapper.selectByNameLike(productname);
    }
}
