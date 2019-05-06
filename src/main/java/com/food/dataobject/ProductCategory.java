package com.food.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**类目实体类
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 09:12
 */
@Entity
/**
 * DynamicUpdate执行update操作更新修改时间为当前时间
 */
@DynamicUpdate
@Data
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
    private Date  createTime;
    private Date  updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
