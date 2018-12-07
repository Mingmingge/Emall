package com.emall.spring.services;

import com.emall.spring.dao.CustomerMapper;
import com.emall.spring.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService implements CustomerMapper{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int deleteByPrimaryKey(String customerid) {
        return customerMapper.deleteByPrimaryKey(customerid);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public Customer selectByPrimaryKey(String customerid) {
        return customerMapper.selectByPrimaryKey(customerid);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ArrayList<Customer> selectAll() {
        return customerMapper.selectAll();
    }

    @Override
    public Customer selectByTel(String tel) {
        return customerMapper.selectByTel(tel);
    }
}
