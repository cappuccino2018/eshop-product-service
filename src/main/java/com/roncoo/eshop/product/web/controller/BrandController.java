package com.roncoo.eshop.product.web.controller;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Category;
import com.roncoo.eshop.product.service.BrandService;
import com.roncoo.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:20
 */

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/add")
    @ResponseBody
    public String addBrand(Brand brand,String operationType){
        try {
            brandService.addBrand(brand,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateBrand(Brand brand,String operationType){
        try {
            brandService.updateBrand(brand,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteBrand(Long id,String operationType){
        try {
            brandService.deleteBrand(id,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Brand findById(Long id){
        try {
            return brandService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/findByIds")
    @ResponseBody
    public List<Brand> findByIds(String ids){
        try {
            return brandService.findByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Brand>();
    }

}
