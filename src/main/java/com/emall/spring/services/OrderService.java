package com.emall.spring.services;

import com.emall.spring.dao.OrderMapper;
import com.emall.spring.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderMapper{
    @Override
    public int deleteByPrimaryKey(String orderid) {
        return 0;
    }

    @Override
    public int insert(Order record) {
        return 0;
    }

    @Override
    public int insertSelective(Order record) {
        return 0;
    }

    @Override
    public Order selectByPrimaryKey(String orderid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return 0;
    }
}
