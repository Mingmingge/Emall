package com.emall.spring.services;

import com.emall.spring.dao.ProductclassMapper;
import com.emall.spring.entity.Productclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductclassService implements ProductclassMapper{

    @Autowired
    private ProductclassMapper productclassMapper;

    @Override
    public int deleteByPrimaryKey(Integer proclassid) {
        return 0;
    }

    @Override
    public int insert(Productclass record) {
        return 0;
    }

    @Override
    public int insertSelective(Productclass record) {
        return 0;
    }

    @Override
    public Productclass selectByPrimaryKey(Integer proclassid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Productclass record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Productclass record) {
        return 0;
    }

    @Override
    public ArrayList<Productclass> selectAll() {
        return productclassMapper.selectAll();
    }
}
