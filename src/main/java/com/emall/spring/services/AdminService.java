package com.emall.spring.services;

import com.emall.spring.dao.AdminMapper;
import com.emall.spring.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements AdminMapper{

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int deleteByPrimaryKey(String adminid) {
        return 0;
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return 0;
    }

    @Override
    public Admin selectByPrimaryKey(String adminid) {
        return adminMapper.selectByPrimaryKey(adminid);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return 0;
    }

    @Override
    public Admin selectByTel(String admintel) {
        return adminMapper.selectByTel(admintel);
    }
}
