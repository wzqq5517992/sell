package com.food.repository;

import com.food.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 10:04
 */
public interface SellerInfoRepository extends JpaRepository< SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
