package com.zhanghao.first.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanghao.first.MainApplication;
import com.zhanghao.first.util.http.HttpClientUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class HttpClientTest {
    @Autowired
    HttpClientUtil httpClientUtil;
    @Test
    public void test() {
        try {
            String str = httpClientUtil.doGet("http://www.baidu.com");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}