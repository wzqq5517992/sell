package com.food.service.impl;

import com.food.dto.OrderDTO;
import com.food.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 14:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1557297586925380229");
        pushMessageService.orderStatus(orderDTO);
    }

}