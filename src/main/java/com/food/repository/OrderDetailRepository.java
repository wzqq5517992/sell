package com.food.repository;

import com.food.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**订单详情表
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 17:27
 */
public interface OrderDetailRepository extends JpaRepository< OrderDetail, String> {

    /**
     * 根据orderId查询订单详细信息
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
