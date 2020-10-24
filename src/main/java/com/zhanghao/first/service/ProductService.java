package com.zhanghao.first.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhanghao.first.model.Product;
import com.zhanghao.first.util.CommonQueryBean;


public interface ProductService {
	/**
	 * 查询全部的商品信息.
	 */
	List<Product> listShowProduct();

	/**
	 * 根据productId查询商品信息.
	 */
	Product findByProductId(Integer productId);
	
	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Product  selectByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( Product record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Product record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Product> list4Page (@Param("record") Product record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count ( Product record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Product> list ( Product record);
	
	/**
	 *  	更新部分字段的方法
	 * @param record
	 * @return
	 */
    int updateItem(Product record) ;
    
    
    List<Product> listByOrderNo(String orderNo );
}
