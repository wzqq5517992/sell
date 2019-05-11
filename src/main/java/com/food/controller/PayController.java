package com.food.controller;

import com.food.dto.OrderDTO;
import com.food.enums.ResultEnum;
import com.food.exception.SellException;
import com.food.service.OrderService;
import com.food.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**微信支付控制层
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-10 09:20
 */
@Controller
@RequestMapping("/pay")
@Api(value="微信支付接口",description = "用于完成微信扫码支付")
public class PayController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    /**
     * 预下单
     * @param orderId
     * @param returnUrl
     * @param map
     * @return
     */
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2. 使用sdk发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create");
    }


    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果,否则微信会一直调用此接口通知订单目前的状态
        return new ModelAndView("pay/success");
    }

}
