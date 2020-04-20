package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.Category;

public interface CategoryService {


    public void addCategory(Category category,String operationType);


    public void updateCategory(Category category,String operationType);


    public void deleteCategory(Long id,String operationType);


    public Category findById(Long id);
}
