package com.food.repository;

import com.food.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**订单主表dao
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 17:25
 */
public interface OrderMasterRepository extends JpaRepository< OrderMaster, String> {

    /**分页-根据openId查询订单主表信息
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
