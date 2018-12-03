package com.emall.spring.services;

import com.emall.spring.dao.ProdisMapper;
import com.emall.spring.dao.ProductMapper;
import com.emall.spring.entity.Prodis;
import com.emall.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Productservice implements ProductMapper{

    @Autowired
    private ProductMapper productMapper;


    @Override
    public int deleteByPrimaryKey(String productid) {
        return 0;
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return 0;
    }

    @Override
    public Product selectByPrimaryKey(String productid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }
}
