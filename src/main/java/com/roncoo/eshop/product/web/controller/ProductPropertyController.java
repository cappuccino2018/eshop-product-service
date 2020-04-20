package com.roncoo.eshop.product.web.controller;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.service.BrandService;
import com.roncoo.eshop.product.service.ProductPropertyService;
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
@RequestMapping("/product-property")
public class ProductPropertyController {

    @Autowired
    private ProductPropertyService productPropertyService;

    @RequestMapping("/add")
    @ResponseBody
    public String addProductProperty(ProductProperty productProperty,String operationType){
        try {
            productPropertyService.addProductProperty(productProperty,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateProductProperty(ProductProperty productProperty,String operationType){
        try {
            productPropertyService.updateProductProperty(productProperty,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteProductProperty(Long id,String operationType){
        try {
            productPropertyService.deleteProductProperty(id,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductProperty findById(Long id){
        try {
            return productPropertyService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductProperty();
    }

    @RequestMapping("/findByProductId")
    @ResponseBody
    public ProductProperty findByProductId(Long productId){
        try {
            return productPropertyService.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductProperty();
    }

}
