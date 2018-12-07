package com.emall.spring.services;

import com.emall.spring.dao.BannerMapper;
import com.emall.spring.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BannerService implements BannerMapper{

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public int deleteByPrimaryKey(String bannerid) {
        return bannerMapper.deleteByPrimaryKey(bannerid);
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerMapper.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(String bannerid) {
        return bannerMapper.selectByPrimaryKey(bannerid);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerMapper.updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<Banner> selectAll() {
        return bannerMapper.selectAll();
    }
}
