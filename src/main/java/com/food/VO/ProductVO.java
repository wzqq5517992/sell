package com.food.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/** 商品VO 包含类目
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:57
 */
@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = 6316503544513562723L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}

