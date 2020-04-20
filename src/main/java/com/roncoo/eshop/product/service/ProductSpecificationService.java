package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.model.ProductSpecification;

public interface ProductSpecificationService {


    public void addProductSpecification(ProductSpecification specification,String operationType);


    public void updateProductSpecification(ProductSpecification specification,String operationType);


    public void deleteProductSpecification(Long id,String operationType);


    public ProductSpecification findById(Long id);

    public ProductSpecification findByProductId(Long productId);
}
