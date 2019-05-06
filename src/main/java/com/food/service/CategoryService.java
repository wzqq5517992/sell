package com.food.service;

import com.food.dataobject.ProductCategory;

import java.util.List;

/**类目service层
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 16:03
 */
public interface CategoryService {
    /**
     * 根据categoryId查询类目信息
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所哟类目信息
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目类型批量查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 新增类目信息
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
