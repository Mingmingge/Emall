package com.emall.spring.services;

import com.emall.spring.dao.DistributeMapper;
import com.emall.spring.entity.Distribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributeService implements DistributeMapper{

    @Autowired
    private DistributeMapper distributeMapper;
    @Override
    public int deleteByPrimaryKey(String distributeid) {
        return distributeMapper.deleteByPrimaryKey(distributeid);
    }

    @Override
    public int insert(Distribute record) {
        return distributeMapper.insert(record);
    }

    @Override
    public int insertSelective(Distribute record) {
        return distributeMapper.insert(record);
    }

    @Override
    public Distribute selectByPrimaryKey(String distributeid) {
        return distributeMapper.selectByPrimaryKey(distributeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Distribute record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Distribute record) {
        return 0;
    }

    @Override
    public Distribute selectByTelPassword(Distribute distribute) {
        return distributeMapper.selectByTelPassword(distribute);
    }
}
