package com.emall.spring.dao;

import com.emall.spring.entity.Prodis;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdisMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Prodis record);

    int insertSelective(Prodis record);

    Prodis selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Prodis record);

    int updateByPrimaryKey(Prodis record);

    Prodis selectByproductid(String productid);
}