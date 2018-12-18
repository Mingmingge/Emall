package com.emall.spring.services;

import com.emall.spring.dao.ReciverMapper;
import com.emall.spring.entity.Reciver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReciverServices implements ReciverMapper{

    @Autowired
    private ReciverMapper reciverMapper;

    @Override
    public int deleteByPrimaryKey(String reciverid) {
        return reciverMapper.deleteByPrimaryKey(reciverid);
    }

    @Override
    public int insert(Reciver record) {
        return reciverMapper.insert(record);
    }

    @Override
    public int insertSelective(Reciver record) {
        return reciverMapper.insertSelective(record);
    }

    @Override
    public Reciver selectByPrimaryKey(String reciverid) {
        return reciverMapper.selectByPrimaryKey(reciverid);
    }

    @Override
    public int updateByPrimaryKeySelective(Reciver record) {
        return reciverMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Reciver record) {
        return reciverMapper.updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<Reciver> selectAll(String customerid) {
        return reciverMapper.selectAll(customerid);
    }
}
