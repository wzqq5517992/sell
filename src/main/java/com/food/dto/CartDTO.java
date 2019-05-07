package com.food.dto;

import lombok.Data;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 22:19
 */
@Data
public class CartDTO {
    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
