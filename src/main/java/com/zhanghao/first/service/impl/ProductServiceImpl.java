package com.zhanghao.first.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.zhanghao.first.dao.ProductDao;
import com.zhanghao.first.model.Product;
import com.zhanghao.first.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> listShowProduct() {
        Product record = new Product();
        record.setState(1);
        return productDao.list(record);
    }
    @Override
    public Product findByProductId(Integer productId) {
        Assert.notNull(productId, "productId is null!");
        Product record = new Product();
        record.setProductId(productId);
        List<Product> list = productDao.list(record);
        if (! CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

}
