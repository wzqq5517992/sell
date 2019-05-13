package com.food.service;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 21:14
 */
public interface SecKillService {
    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 模拟不同用户秒杀同一商品的请求
     * @param productId
     * @return
     */
    void orderProductMockDiffUser(String productId);
}
