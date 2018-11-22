package com.emall.spring.dao;

import com.emall.spring.entity.Prodis;

public interface ProdisMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Prodis record);

    int insertSelective(Prodis record);

    Prodis selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Prodis record);

    int updateByPrimaryKey(Prodis record);
}