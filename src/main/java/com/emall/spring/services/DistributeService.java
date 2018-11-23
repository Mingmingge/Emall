package com.emall.spring.services;

import com.emall.spring.dao.DistributeMapper;
import com.emall.spring.entity.Distribute;
import org.springframework.stereotype.Service;

@Service
public class DistributeService implements DistributeMapper{
    @Override
    public int deleteByPrimaryKey(String distributeid) {
        return 0;
    }

    @Override
    public int insert(Distribute record) {
        return 0;
    }

    @Override
    public int insertSelective(Distribute record) {
        return 0;
    }

    @Override
    public Distribute selectByPrimaryKey(String distributeid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Distribute record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Distribute record) {
        return 0;
    }
}
