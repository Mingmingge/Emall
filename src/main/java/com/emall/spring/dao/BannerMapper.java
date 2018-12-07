package com.emall.spring.dao;

import com.emall.spring.entity.Banner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(String bannerid);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(String bannerid);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    ArrayList<Banner> selectAll();
}