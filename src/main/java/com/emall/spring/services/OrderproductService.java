package com.emall.spring.services;

import com.emall.spring.dao.OrderproductMapper;
import com.emall.spring.entity.Orderproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderproductService implements OrderproductMapper {

    @Autowired
    private OrderproductMapper orderproductMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return orderproductMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Orderproduct record) {
        return orderproductMapper.insert(record);
    }

    @Override
    public int insertSelective(Orderproduct record) {
        return orderproductMapper.insertSelective(record);
    }

    @Override
    public Orderproduct selectByPrimaryKey(String uuid) {
        return orderproductMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderproduct record) {
        return orderproductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderproduct record) {
        return updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<Orderproduct> selectByOrderid(String orderid) {
        return orderproductMapper.selectByOrderid(orderid);
    }
}
