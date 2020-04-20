package com.roncoo.eshop.product.web.controller;

import com.roncoo.eshop.product.model.ProductIntro;
import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.service.ProductIntroService;
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
@RequestMapping("/product-intro")
public class ProductIntroController {

    @Autowired
    private ProductIntroService productIntroService;

    @RequestMapping("/add")
    @ResponseBody
    public String addProductIntro(ProductIntro productIntro,String operationType){
        try {
            productIntroService.addProductIntro(productIntro,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateProductIntro(ProductIntro productIntro,String operationType){
        try {
            productIntroService.updateProductIntro(productIntro,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteProductIntro(Long id,String operationType){
        try {
            productIntroService.deleteProductIntro(id,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductIntro findById(Long id){
        try {
            return productIntroService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductIntro();
    }

}
