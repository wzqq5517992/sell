package com.food.service;

import com.food.dto.OrderDTO;

/**买家service
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-08 15:49
 */
public interface BuyerService {
    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
