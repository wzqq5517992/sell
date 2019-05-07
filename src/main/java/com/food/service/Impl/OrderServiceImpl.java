package com.food.service.Impl;

import com.food.dataobject.OrderDetail;
import com.food.dataobject.ProductInfo;
import com.food.dto.OrderDTO;
import com.food.enums.ResultEnum;
import com.food.exception.SellException;
import com.food.repository.OrderDetailRepository;
import com.food.repository.OrderMasterRepository;
import com.food.service.OrderService;
import com.food.service.ProductService;
import com.food.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 22:30
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1.查询商品
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            //查询商品信息
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
        }
        //2.计算总价
        //3. 写入订单数据库（orderMaster和orderDetail）
        //4. 扣库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
