package com.zhanghao.first.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanghao.first.MainApplication;
import com.zhanghao.first.dao.ProductDao;
import com.zhanghao.first.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ProductTest {
    @Autowired 
    private ProductDao productDao;
    @Test
    public void testQuery() {
        Product record = new Product();
        record.setState(1);
        List<Product> list = productDao.list(record);
        System.out.println(list.size());
    }
}