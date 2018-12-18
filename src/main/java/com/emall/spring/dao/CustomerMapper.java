package com.emall.spring.dao;

import com.emall.spring.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(String customerid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String customerid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    ArrayList<Customer> selectAll();

    Customer selectByTel(String tel);
}