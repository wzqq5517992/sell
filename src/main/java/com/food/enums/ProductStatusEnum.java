package com.food.enums;
import lombok.Getter;
/**商品状态枚举
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:26
 */

@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}