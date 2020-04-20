package com.roncoo.eshop.product.mapper;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Category;
import com.roncoo.eshop.product.model.Product;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMaper {

    @Insert("INSERT INTO product(name,category_id,brand_id) VALUES(#{name},#{categoryId},#{brandId})")
    public void addProduct(Product product);

    @Update("UPDATE product set name=#{name},category_id=#{categoryId},brand_id=${brandId} WHERE id=#{id}")
    public void updateProduct(Product product);

    @Delete("DELETE FROM product WHERE id=#{id}")
    public void deleteProduct(Long id);

    @Select("SELECT * FROM product WHERE id=#{id}")
    @Results({
        @Result(column = "category_id",property = "categoryId"),
        @Result(column = "brand_id",property = "brandId")
    })
    public Product findById(Long id);


}
