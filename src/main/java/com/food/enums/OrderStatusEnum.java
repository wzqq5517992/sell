package com.food.enums;

import lombok.Getter;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 17:18
 */
@Getter
public enum OrderStatusEnum {
    /**
     * 订单状态
     */
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
