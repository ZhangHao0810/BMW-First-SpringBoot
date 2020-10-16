package com.zhanghao.first.service;

import java.util.List;

import com.zhanghao.first.model.Product;


public interface ProductService {
	/**
	 * 查询全部的商品信息.
	 */
	List<Product> listShowProduct();

	/**
	 * 根据productId查询商品信息.
	 */
	Product findByProductId(Integer productId);
}
