package com.food.service;

import com.food.dataobject.SellerInfo;

/**卖家信息service
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 10:09
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
