package com.food.service;

import com.food.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:20
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     *  todo 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * todo 分页查询在架商品列表
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * todo 保存活新增商品
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}