package com.food.service.impl;

import com.food.dataobject.SellerInfo;
import com.food.repository.SellerInfoRepository;
import com.food.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**卖家信息实现类
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 10:10
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
