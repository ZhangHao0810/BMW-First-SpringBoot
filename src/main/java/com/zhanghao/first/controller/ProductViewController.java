package com.zhanghao.first.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhanghao.first.model.Product;
import com.zhanghao.first.service.ProductService;
import com.zhanghao.first.util.CommonQueryBean;

/**
 * 	该controller 负责返回JSP页面， 而不是 Json数据。	
 * @author ZhangHao
 *  2020-10-22
 */
@Controller //注意，这块注解表示的是普通的controller
@RequestMapping(value = "/productview")
public class ProductViewController {
    @Autowired
    private ProductService productService;
    //添加页面
    @RequestMapping("/add")
    public String add() {
        return "add";
    }
    //添加实际的业务逻辑
    @RequestMapping("/addProduct")//BingdingResult 可以让加了@Valid的pojo返回相应的验证。
    public String listUser(@Valid Product product, BindingResult bindingResult, Model model) throws Exception {
        int result = productService.insert(product);
        if (result < 0) {
            model.addAttribute("result", result);
            return "add";
        }
        return "redirect:listProduct";
    }
    //删除
    @RequestMapping("/deleteProduct")
    public String deleteUser(Long id) throws Exception {
        productService.deleteByPrimaryKey(id);
        return "redirect:listProduct";
    }
    //查找(用于单个查询)
    @RequestMapping("/getProduct")
    public String getProduct(Long id, Model model) throws Exception {
        Product product = productService.selectByPrimaryKey(id);
        model.addAttribute("product", product);
        return "productShow";
    }
   
    
    /**
     *  //分页遍历，默认每页3条   
     *  	一定要结合mapping里面的sql 还有前端 搞清楚这个分页的实际流程。要能手敲分页逻辑。
     * @param name
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/listProduct")
    public String listProduct(@RequestParam(value = "name",defaultValue = "") String name,
                           Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) throws Exception {
        Product record = new Product();
        if (StringUtils.isNotEmpty(name)) {
            record.setName(name);
            model.addAttribute("name", name);
        }
        //计算总数量
        long total = productService.count(record);
        //计算总页数
        int totalPageNum = (int)total / pageSize;
        if (total % pageSize > 0) totalPageNum ++;
        //分页相关参数
        CommonQueryBean query= new CommonQueryBean();
        query.setPageSize(pageSize);
        query.setPageNum(pageNum);
        query.setStart((pageNum-1) * pageSize);
        List<Product> list = productService.list4Page(record, query);
        model.addAttribute("total", total);
        model.addAttribute("totalPage", totalPageNum);
        model.addAttribute("list", list);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);        
        return "index";
    }
    //修改
    @RequestMapping("/update")
    public String updateUser(Long id, Model model) throws Exception {
        Product product = productService.selectByPrimaryKey(id);
        model.addAttribute("product", product);
        return "update";
    }
    //修改实际的业务逻辑
    @RequestMapping("/updateProduct")
    public String findUser(Product product) throws Exception {
        productService.updateItem(product);
        return "redirect:listProduct";
    }
}