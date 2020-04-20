package com.roncoo.eshop.product.mapper;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.ProductProperty;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductPropertyMaper {

    @Insert("INSERT INTO product_property(name,value,product_id) VALUES(#{name},#{value},#{productId})")
    public void addProductProperty(ProductProperty productProperty);

    @Update("UPDATE product_property set name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")
    public void updateProductProperty(ProductProperty productProperty);

    @Delete("DELETE FROM product_property WHERE id=#{id}")
    public void deleteProductProperty(Long id);

    @Select("SELECT * FROM product_property WHERE id=#{id}")
    public ProductProperty findById(Long id);

    @Select("SELECT * FROM product_property WHERE product_id=#{productId}")
    public ProductProperty findByProductId(Long productId);


}
