package com.emall.spring.services;

import com.emall.spring.dao.OrderproductMapper;
import com.emall.spring.entity.Orderproduct;
import org.springframework.stereotype.Service;

@Service
public class OrderproductService implements OrderproductMapper {
    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Orderproduct record) {
        return 0;
    }

    @Override
    public int insertSelective(Orderproduct record) {
        return 0;
    }

    @Override
    public Orderproduct selectByPrimaryKey(String uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Orderproduct record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Orderproduct record) {
        return 0;
    }
}
