package com.emall.spring.dao;

import com.emall.spring.entity.Orderproduct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderproductMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Orderproduct record);

    int insertSelective(Orderproduct record);

    Orderproduct selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Orderproduct record);

    int updateByPrimaryKey(Orderproduct record);

    ArrayList<Orderproduct> selectByOrderid(String orderid);
}