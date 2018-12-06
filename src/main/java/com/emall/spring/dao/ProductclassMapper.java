package com.emall.spring.dao;

import com.emall.spring.entity.Productclass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductclassMapper {
    int deleteByPrimaryKey(Integer proclassid);

    int insert(Productclass record);

    int insertSelective(Productclass record);

    Productclass selectByPrimaryKey(Integer proclassid);

    int updateByPrimaryKeySelective(Productclass record);

    int updateByPrimaryKey(Productclass record);

    ArrayList<Productclass> selectAll();
}