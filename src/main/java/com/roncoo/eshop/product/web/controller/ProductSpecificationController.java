package com.roncoo.eshop.product.web.controller;

import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.model.ProductSpecification;
import com.roncoo.eshop.product.service.ProductPropertyService;
import com.roncoo.eshop.product.service.ProductSpecificationService;
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
@RequestMapping("/product-specification")
public class ProductSpecificationController {

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @RequestMapping("/add")
    @ResponseBody
    public String addProductProperty(ProductSpecification productSpecification,String operationType){
        try {
            productSpecificationService.addProductSpecification(productSpecification,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateProductProperty(ProductSpecification productSpecification,String operationType){
        try {
            productSpecificationService.updateProductSpecification(productSpecification,operationType);
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
            productSpecificationService.deleteProductSpecification(id,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductSpecification findById(Long id){
        try {
            return productSpecificationService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductSpecification();
    }

    @RequestMapping("/findByProductId")
    @ResponseBody
    public ProductSpecification findByProductId(Long productId){
        try {
            return productSpecificationService.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductSpecification();
    }

}
