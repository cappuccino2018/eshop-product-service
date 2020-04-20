package com.roncoo.eshop.product.web.controller;

import com.roncoo.eshop.product.model.Category;
import com.roncoo.eshop.product.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add")
    @ResponseBody
    public String addCategory(Category category,String operationType){
        try {
            categoryService.addCategory(category,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateCategory(Category category,String operationType){
        try {
            categoryService.updateCategory(category,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteCategory(Long id,String operationType){
        try {
            categoryService.deleteCategory(id,operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Category findById(Long id){
        try {
            return categoryService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
