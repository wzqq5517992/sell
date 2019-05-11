package com.food.service;

import com.food.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**微信支付service
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-10 09:36
 */
public interface PayService {
    /**
     * 微信支付预下单
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信支付异步通知
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);

    /**
     * 微信退款
     * @param orderDTO
     * @return
     */
    RefundResponse refund(OrderDTO orderDTO);
}
