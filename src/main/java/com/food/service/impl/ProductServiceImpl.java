package com.food.service.impl;

import com.food.dataobject.ProductInfo;
import com.food.dto.CartDTO;
import com.food.enums.ProductStatusEnum;
import com.food.enums.ResultEnum;
import com.food.exception.SellException;
import com.food.repository.ProductInfoRepository;
import com.food.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**商品实现类
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:23
 */
@SuppressWarnings({"ALL", "AlibabaTransactionMustHaveRollback"})
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @SuppressWarnings("AlibabaTransactionMustHaveRollback")
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo==null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }
    @SuppressWarnings("AlibabaTransactionMustHaveRollback")
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            Optional< ProductInfo > productInfo = repository.findById(cartDTO.getProductId());
            if (!productInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.get().getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.get().setProductStock(result);

            repository.save(productInfo.get());
        }
    }
}
