package com.zhanghao.first.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zhanghao.first.model.Product;

@Repository //采用这个注解来声明dao
public interface ProductDao{
    /**
     * 
     * 查询（根据主键ID查询）
     * 
     **/
    Product  selectByPrimaryKey ( @Param("id") Long id );
    /**
     * 
     * 添加
     * 
     **/
    int insert( Product record );
        /**
     * 
     * list查询
     * 
     **/
    List<Product> list ( Product record);
}