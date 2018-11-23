package com.emall.spring.dao;

import com.emall.spring.entity.Distribute;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributeMapper {
    int deleteByPrimaryKey(String distributeid);

    int insert(Distribute record);

    int insertSelective(Distribute record);

    Distribute selectByPrimaryKey(String distributeid);

    int updateByPrimaryKeySelective(Distribute record);

    int updateByPrimaryKey(Distribute record);
}