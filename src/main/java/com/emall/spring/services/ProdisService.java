package com.emall.spring.services;

import com.emall.spring.dao.ProdisMapper;
import com.emall.spring.entity.Prodis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdisService implements ProdisMapper{

    @Autowired
    private ProdisMapper prodisMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return prodisMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Prodis record) {
        return prodisMapper.insert(record);
    }

    @Override
    public int insertSelective(Prodis record) {
        return prodisMapper.insertSelective(record);
    }

    @Override
    public Prodis selectByPrimaryKey(String uuid) {
        return prodisMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Prodis record) {
        return prodisMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Prodis record) {
        return prodisMapper.updateByPrimaryKey(record);
    }
}
