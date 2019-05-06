package com.food.repository;

import com.food.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 09:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 查询单条信息
     */
    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory = repository.findById(1);
        productCategory.ifPresent(s -> System.out.println("wzq:"+s.toString()));

    }

    /**
     * 添加修改类目
     */
    @Test
    @Transactional
    public void saveTest() {
//        Optional<ProductCategory> productCategory = repository.findById(8);
//        productCategory.get().setCategoryType(12);
//         ProductCategory result = repository.save(productCategory.get());
        ProductCategory productCategory = new ProductCategory("nvs生最爱", 9);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null, result);
    }

    /**
     * 批量查询类目信息
     */
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(9,12);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        result.stream().forEach(s-> System.out.println(s.getCategoryName()));
        Assert.assertNotEquals(0, result.size());
    }

}