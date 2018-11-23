package com.emall.spring.services;

import com.emall.spring.dao.CustomerMapper;
import com.emall.spring.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerMapper{
    @Override
    public int deleteByPrimaryKey(String customerid) {
        return 0;
    }

    @Override
    public int insert(Customer record) {
        return 0;
    }

    @Override
    public int insertSelective(Customer record) {
        return 0;
    }

    @Override
    public Customer selectByPrimaryKey(String customerid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return 0;
    }
}
