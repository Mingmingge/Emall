package com.emall.spring.services;

import com.emall.spring.dao.ProdisMapper;
import com.emall.spring.entity.Prodis;
import org.springframework.stereotype.Service;

@Service
public class ProdisService implements ProdisMapper{
    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Prodis record) {
        return 0;
    }

    @Override
    public int insertSelective(Prodis record) {
        return 0;
    }

    @Override
    public Prodis selectByPrimaryKey(String uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Prodis record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Prodis record) {
        return 0;
    }
}
