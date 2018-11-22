package com.emall.spring.dao;

import com.emall.spring.entity.Repertory;

public interface RepertoryMapper {
    int deleteByPrimaryKey(String repertoryid);

    int insert(Repertory record);

    int insertSelective(Repertory record);

    Repertory selectByPrimaryKey(String repertoryid);

    int updateByPrimaryKeySelective(Repertory record);

    int updateByPrimaryKey(Repertory record);
}