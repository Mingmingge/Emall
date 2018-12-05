package com.emall.spring.dao;

import com.emall.spring.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(String productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    ArrayList<Product> selectAll();

    int updateState(Product record);

    ArrayList<Product> selectByNameLike(String productname);
}