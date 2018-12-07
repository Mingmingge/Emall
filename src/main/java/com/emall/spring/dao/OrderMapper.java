package com.emall.spring.dao;

import com.emall.spring.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    ArrayList<Order> selectAll();
}