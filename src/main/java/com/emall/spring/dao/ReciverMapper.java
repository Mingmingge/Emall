package com.emall.spring.dao;

import com.emall.spring.entity.Reciver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ReciverMapper {
    int deleteByPrimaryKey(String reciverid);

    int insert(Reciver record);

    int insertSelective(Reciver record);

    Reciver selectByPrimaryKey(String reciverid);

    int updateByPrimaryKeySelective(Reciver record);

    int updateByPrimaryKey(Reciver record);

    ArrayList<Reciver> selectAll(String customerid);
}