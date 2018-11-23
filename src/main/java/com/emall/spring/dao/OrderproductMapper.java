package com.emall.spring.dao;

import com.emall.spring.entity.Orderproduct;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderproductMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Orderproduct record);

    int insertSelective(Orderproduct record);

    Orderproduct selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Orderproduct record);

    int updateByPrimaryKey(Orderproduct record);
}