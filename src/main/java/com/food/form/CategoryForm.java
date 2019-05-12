package com.food.form;

import lombok.Data;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-12 22:02
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
