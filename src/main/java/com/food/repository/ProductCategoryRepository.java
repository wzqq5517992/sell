package com.food.repository;

import com.food.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/** 类目dao
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 09:16
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
