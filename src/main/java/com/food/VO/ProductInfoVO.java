package com.food.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**商品详情VO
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:56
 */
@Data
public class ProductInfoVO  implements Serializable {


    private static final long serialVersionUID = -1140303265146507090L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
