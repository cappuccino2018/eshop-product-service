package com.roncoo.eshop.product.mapper;

import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.model.ProductSpecification;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductSpecificationMaper {

    @Insert("INSERT INTO product_specification(name,value,product_id) VALUES(#{name},#{value},#{productId})")
    public void addProductSpecification(ProductSpecification specification);

    @Update("UPDATE product_specification set name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")
    public void updateProductSpecification(ProductSpecification specification);

    @Delete("DELETE FROM product_specification WHERE id=#{id}")
    public void deleteProductSpecification(Long id);

    @Select("SELECT * FROM product_specification WHERE id=#{id}")
    public ProductSpecification findById(Long id);

    @Select("SELECT * FROM product_specification WHERE product_id=#{productId}")
    public ProductSpecification findByProductId(Long productId);
}
