package com.food.enums;

import lombok.Getter;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 17:19
 */
@Getter
public enum PayStatusEnum implements  CodeEnum {

    /**
     * 支付状态
     */
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
