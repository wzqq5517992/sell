package com.food.controller;

import com.food.VO.ProductInfoVO;
import com.food.VO.ProductVO;
import com.food.VO.ResultVO;
import com.food.dataobject.ProductCategory;
import com.food.dataobject.ProductInfo;
import com.food.service.CategoryService;
import com.food.service.ProductService;
import com.food.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品controller
 *
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:48
 */

@RestController
@RequestMapping("/buyer/product")
@Api(value="买家商品信息接口",description = "买家用于查询商品的各类信息")
@Slf4j
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value="查询所有上架商品信息及类目", notes="无入参")
   // @ApiImplicitParam(name = "id", value = "用户ID")
    @SuppressWarnings("AlibabaRemoveCommentedCode")
    @GetMapping("/list")
    public ResultVO list() {
        // http://3pd3fd.natappfree.cc
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目,一次性查出来
       // List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //todo lambda表达式
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //获取对应类目编号的list及集合
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3. 数据拼装list套ProductVO的集合
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
