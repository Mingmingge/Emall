package com.emall.spring.services;

import com.emall.spring.dao.RepertoryMapper;
import com.emall.spring.entity.Repertory;
import org.springframework.stereotype.Service;

@Service
public class RepertoryService implements RepertoryMapper{
    @Override
    public int deleteByPrimaryKey(String repertoryid) {
        return 0;
    }

    @Override
    public int insert(Repertory record) {
        return 0;
    }

    @Override
    public int insertSelective(Repertory record) {
        return 0;
    }

    @Override
    public Repertory selectByPrimaryKey(String repertoryid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Repertory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Repertory record) {
        return 0;
    }
}
