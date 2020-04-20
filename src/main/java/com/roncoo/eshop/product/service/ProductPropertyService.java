package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.ProductProperty;

public interface ProductPropertyService {


    public void addProductProperty(ProductProperty productProperty,String operationType);


    public void updateProductProperty(ProductProperty productProperty,String operationType);


    public void deleteProductProperty(Long id,String operationType);


    public ProductProperty findById(Long id);

    public ProductProperty findByProductId(Long productId);
}
