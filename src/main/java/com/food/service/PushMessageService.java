package com.food.service;

import com.food.dto.OrderDTO;

/**推送消息
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 14:00
 */
public interface PushMessageService {
    /**
     * 订单状态变更，推送消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
