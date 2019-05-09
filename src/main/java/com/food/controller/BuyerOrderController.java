package com.food.controller;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-08 13:40
 */

import com.food.VO.ResultVO;
import com.food.converter.OrderForm2OrderDTOConverter;
import com.food.dto.OrderDTO;
import com.food.enums.ResultEnum;
import com.food.exception.SellException;
import com.food.service.BuyerService;
import com.food.service.OrderService;
import com.food.utils.ResultVOUtil;
import com.food.form.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
@Api(value="买家订单信息接口",description = "买家操作订单信息")
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
@ApiOperation(value="买家创建订单", notes="orderForm")
public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                            BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        log.error("【创建订单】参数不正确, orderForm={}", orderForm);
        throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
    if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
        log.error("【创建订单】购物车不能为空");
        throw new SellException(ResultEnum.CART_EMPTY);
    }
    OrderDTO createResult = orderService.create(orderDTO);

    Map<String, String> map = new HashMap<>();
    map.put("orderId", createResult.getOrderId());

    return ResultVOUtil.success(map);
}


    /**
     * 订单列表
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value="全部订单列表", notes="orderForm")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page-1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }


    /**
     * 订单详情
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    @ApiOperation(value="订单详情", notes="orderForm")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {


          OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    @ApiOperation(value="订单取消", notes="orderForm")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

         buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }


}
