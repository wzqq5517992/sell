package com.food.mapper.dao;

import com.food.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 20:25
 */
public class ProductCategoryDao {
    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
