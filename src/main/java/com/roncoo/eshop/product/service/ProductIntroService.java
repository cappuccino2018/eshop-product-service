package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.ProductIntro;
import com.roncoo.eshop.product.model.ProductProperty;

public interface ProductIntroService {


    public void addProductIntro(ProductIntro productIntro,String operationType);


    public void updateProductIntro(ProductIntro productIntro,String operationType);


    public void deleteProductIntro(Long id,String operationType);


    public ProductIntro findById(Long id);
}
