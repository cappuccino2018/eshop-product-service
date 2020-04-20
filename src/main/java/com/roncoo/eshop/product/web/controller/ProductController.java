package com.roncoo.eshop.product.web.controller;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Category;
import com.roncoo.eshop.product.model.Product;
import com.roncoo.eshop.product.service.BrandService;
import com.roncoo.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:20
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    @ResponseBody
    public String addProduct(Product product,String operationType){
        try {
            productService.addProduct(product,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateProduct(Product product,String operationType){
        try {
            productService.updateProduct(product,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteProduct(Long id,String operationType){
        try {
            productService.deleteProduct(id,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Product findById(Long id){
        try {
            return productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
