package com.emall.spring.services;

import com.emall.spring.dao.OrderMapper;
import com.emall.spring.dao.ReciverMapper;
import com.emall.spring.entity.Order;
import com.emall.spring.entity.Reciver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService implements OrderMapper{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(String orderid) {
        return orderMapper.deleteByPrimaryKey(orderid);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(String orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public ArrayList<Order> selectByreciver(String reciverid) {
        return orderMapper.selectByreciver(reciverid);
    }

    @Override
    public ArrayList<Order> selectByreciverandstate(Order order) {
        return orderMapper.selectByreciverandstate(order);
    }
}
