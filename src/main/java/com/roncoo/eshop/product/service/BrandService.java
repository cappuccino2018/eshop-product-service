package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Category;

import java.util.List;

public interface BrandService {


    public void addBrand(Brand brand,String operationType);


    public void updateBrand(Brand brand,String operationType);


    public void deleteBrand(Long id,String operationType);


    public Brand findById(Long id);

    public List<Brand> findByIds(String ids);
}
