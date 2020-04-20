package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Product;

public interface ProductService {


    public void addProduct(Product product,String operationType);


    public void updateProduct(Product product,String operationType);


    public void deleteProduct(Long id,String operationType);


    public Product findById(Long id);
}
